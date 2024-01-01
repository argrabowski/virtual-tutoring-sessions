package org.assistments.vts.manager.impl.support;

import java.util.List;
import java.util.Optional;

import org.assistments.domain.exception.NotFoundException;
import org.assistments.service.exceptions.AlreadyExistsException;
import org.assistments.util.Pair;
import org.assistments.vts.dao.MeetingInfoAbstractDao;
import org.assistments.vts.domain.MeetingInfo;
import org.assistments.vts.manager.MeetingHandler;
import org.assistments.vts.manager.ZoomRequestHandler;
import org.assistments.vts.util.request.CreateMeetingRequest;
import org.springframework.stereotype.Component;

@Component
public class Meeting implements MeetingHandler
{

  private final MeetingInfoAbstractDao meetingDao;
  private final ZoomRequestHandler zoomHandler;

  public Meeting(final MeetingInfoAbstractDao meetingDao, final ZoomRequestHandler zoomHandler)
  {
    this.meetingDao = meetingDao;
    this.zoomHandler = zoomHandler;
  }

  @Override
  public List<MeetingInfo> getMeetings()
  {
    try
    {
      return this.meetingDao.findAllObjects();
    }
    catch (NotFoundException e)
    {
      return null;
    }
  }

  @Override
  public MeetingInfo createMeeting(CreateMeetingRequest request)
  {
    Pair<Pair<Long, String>, Optional<String>> response =
        zoomHandler.getZoomURL(request.getExpectedStartTime(),
        request.getExpectedDuration());

    if (response.getFirst() == null)
    {
      return null;
    }

    long idResponse = response.getFirst().getFirst();
    String urlResponse = response.getFirst().getSecond();

    try
    {
      MeetingInfo responseInfo = new MeetingInfo();
      responseInfo.setSupervisorID(request.getSupervisorID());
      responseInfo.setTutorID(request.getTutorID());
      responseInfo.setStudentID1(request.getStudentID1());
      responseInfo.setStudentID2(request.getStudentID2());
      responseInfo.setExpectedStartTime(request.getExpectedStartTime());
      responseInfo.setExpectedDuration(request.getExpectedDuration());
      responseInfo.setZoomID(idResponse);
      responseInfo.setZoomLink(urlResponse);
      responseInfo.setDbid(meetingDao.persist(responseInfo));
      return responseInfo;
    }
    catch (AlreadyExistsException e)
    {
      return null;
    }

  }
}
