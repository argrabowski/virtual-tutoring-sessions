package org.assistments.vts.manager.impl;

import org.assistments.vts.domain.MeetingLogInfo;
import org.assistments.vts.manager.MeetingLogManager;
import org.assistments.vts.manager.MeetingLogHandler;
import org.assistments.vts.util.request.CreateMeetingLogRequest;
import org.springframework.stereotype.Component;

@Component
public class MeetingLogManagerImpl implements MeetingLogManager
{
  private MeetingLogHandler mLHandler;

  public MeetingLogManagerImpl(final MeetingLogHandler mLHandler)
  {
    this.mLHandler = mLHandler;
  }

  @Override
  public MeetingLogInfo getMeetingLog(int id)
  {
    return mLHandler.getMeetingLog(id);
  }

  @Override
  public MeetingLogInfo createMeetingLog(CreateMeetingLogRequest request)
  {
    return mLHandler.createMeetingLog(request);
  }
}
