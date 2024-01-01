package org.assistments.vts.manager;

import org.assistments.vts.domain.MeetingLogInfo;
import org.assistments.vts.util.request.CreateMeetingLogRequest;

public interface MeetingLogManager
{

  MeetingLogInfo getMeetingLog(int id);

  MeetingLogInfo createMeetingLog(CreateMeetingLogRequest request);

}
