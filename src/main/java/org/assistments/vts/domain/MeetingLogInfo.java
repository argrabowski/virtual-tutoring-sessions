package org.assistments.vts.domain;

import org.assistments.domain.DbObjectImpl;

public class MeetingLogInfo extends DbObjectImpl
{
  private int meetingID;
  private String zoomRecording;
  private String comment;

  public MeetingLogInfo()
  {
    meetingID = -1;
  }

  public int getMeetingID()
  {
    return meetingID;
  }

  public void setMeetingID(int meetingID)
  {
    this.meetingID = meetingID;
  }

  public String getZoomRecording()
  {
    return zoomRecording;
  }

  public void setZoomRecording(String zoomRecording)
  {
    this.zoomRecording = zoomRecording;
  }

  public String getComment()
  {
    return comment;
  }

  public void setComment(String comment)
  {
    this.comment = comment;
  }
}
