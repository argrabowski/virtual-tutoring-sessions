package org.assistments.vts.manager;

import java.util.List;

import org.assistments.vts.domain.MeetingInfo;
import org.assistments.vts.util.request.CreateMeetingRequest;

public interface MeetingHandler
{
  List<MeetingInfo> getMeetings();

  MeetingInfo createMeeting(final CreateMeetingRequest meetingRequest);
}
