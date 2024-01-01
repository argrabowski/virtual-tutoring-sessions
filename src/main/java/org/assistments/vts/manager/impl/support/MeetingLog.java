package org.assistments.vts.manager.impl.support;

import java.util.Optional;

import org.assistments.domain.exception.NotFoundException;
import org.assistments.service.exceptions.AlreadyExistsException;
import org.assistments.util.Pair;
import org.assistments.vts.dao.MeetingInfoAbstractDao;
import org.assistments.vts.dao.MeetingLogInfoAbstractDao;
import org.assistments.vts.domain.MeetingInfo;
import org.assistments.vts.domain.MeetingLogInfo;
import org.assistments.vts.manager.MeetingLogHandler;
import org.assistments.vts.manager.ZoomRequestHandler;
import org.assistments.vts.util.request.CreateMeetingLogRequest;
import org.springframework.stereotype.Component;

@Component
public class MeetingLog implements MeetingLogHandler
{

  private final MeetingInfoAbstractDao meetingDao;
  private final MeetingLogInfoAbstractDao meetingLogDao;
  private final ZoomRequestHandler zoomHandler;


  public MeetingLog(final MeetingInfoAbstractDao meetingDao, final MeetingLogInfoAbstractDao meetingLogDao,
      final ZoomRequestHandler zoomHandler)
  {
    this.meetingDao = meetingDao;
    this.meetingLogDao = meetingLogDao;
    this.zoomHandler = zoomHandler;
  }

  @Override
  public MeetingLogInfo getMeetingLog(int id)
  {
    try
    {
      return meetingLogDao.findObject(MeetingLogInfoAbstractDao.Field.MEETING_ID.getQueryTerm(id));
    }
    catch (NotFoundException e)
    {
      return null;
    }
  }

  @Override
  public MeetingLogInfo createMeetingLog(CreateMeetingLogRequest request)
  {

    Long zoomId = 0L;
    try
    {
      MeetingInfo meeting = meetingDao.findById(request.getMeetingID());
      zoomId = meeting.getZoomID();
    }
    catch (NotFoundException e)
    {
      return null;
    }

    Pair<String, Optional<String>> response = zoomHandler.getZoomRecording(zoomId);

    if (response.getFirst() == null)
    {
      return null;
    }

    String urlResponse = response.getFirst();

    try
    {
      MeetingLogInfo responseInfo = new MeetingLogInfo();
      responseInfo.setMeetingID(request.getMeetingID());
      responseInfo.setZoomRecording(urlResponse);
      responseInfo.setComment(request.getComment());
      responseInfo.setDbid(meetingLogDao.persist(responseInfo));
      return responseInfo;
    }
    catch (AlreadyExistsException e)
    {
      return null;
    }


  }
}
