package org.assistments.vts.manager;

import org.assistments.vts.domain.MeetingLogInfo;
import org.assistments.vts.util.request.CreateMeetingLogRequest;

public interface MeetingLogHandler
{
  MeetingLogInfo getMeetingLog(int id);

  MeetingLogInfo createMeetingLog(CreateMeetingLogRequest request);
}
