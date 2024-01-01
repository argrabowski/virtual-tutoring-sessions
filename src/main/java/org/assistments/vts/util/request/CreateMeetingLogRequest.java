package org.assistments.vts.util.request;

public class CreateMeetingLogRequest
{
  private int meetingID;
  private String comment;

  public CreateMeetingLogRequest()
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

  public String getComment()
  {
    return comment;
  }

  public void setComment(String comment)
  {
    this.comment = comment;
  }

}
