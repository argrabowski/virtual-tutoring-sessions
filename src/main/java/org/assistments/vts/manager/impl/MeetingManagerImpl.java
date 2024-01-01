package org.assistments.vts.manager.impl;

import java.util.List;

import org.assistments.domain.exception.NotFoundException;
import org.assistments.vts.domain.MeetingInfo;
import org.assistments.vts.manager.MeetingManager;
import org.assistments.vts.manager.MeetingHandler;
import org.assistments.vts.util.request.CreateMeetingRequest;
import org.springframework.stereotype.Component;

@Component
public class MeetingManagerImpl implements MeetingManager
{
  public final MeetingHandler handler;

  public MeetingManagerImpl(final MeetingHandler handler)
  {
    this.handler = handler;
  }

  @Override
  public List<MeetingInfo> getMeetings() throws NotFoundException
  {
    return this.handler.getMeetings();
  }

  @Override
  public MeetingInfo createMeeting(CreateMeetingRequest request)
  {
    return this.handler.createMeeting(request);
  }
}
