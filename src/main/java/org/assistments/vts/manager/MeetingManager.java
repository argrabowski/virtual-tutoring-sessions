package org.assistments.vts.manager;

import java.util.List;

import org.assistments.domain.exception.NotFoundException;
import org.assistments.vts.domain.MeetingInfo;
import org.assistments.vts.util.request.CreateMeetingRequest;

public interface MeetingManager
{
  List<MeetingInfo> getMeetings() throws NotFoundException;

  MeetingInfo createMeeting(CreateMeetingRequest meetingRequest);
}
