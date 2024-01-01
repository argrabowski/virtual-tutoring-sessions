package org.assistments.vts.domain;

import java.sql.Timestamp;
import java.time.Instant;

import org.assistments.domain.DbObjectImpl;

public class MeetingInfo extends DbObjectImpl
{
  private int supervisorID;
  private int tutorID;
  private int studentID1;
  private int studentID2;
  private Instant expectedStartTime;
  private int expectedDuration;
  private long zoomID;
  private String zoomLink;

  public MeetingInfo()
  {
  }

  public int getSupervisorID()
  {
    return supervisorID;
  }

  public void setSupervisorID(int supervisorID)
  {
    this.supervisorID = supervisorID;
  }

  public int getTutorID()
  {
    return tutorID;
  }

  public void setTutorID(int tutorID)
  {
    this.tutorID = tutorID;
  }

  public int getStudentID1()
  {
    return studentID1;
  }

  public void setStudentID1(int studentID1)
  {
    this.studentID1 = studentID1;
  }

  public int getStudentID2()
  {
    return studentID2;
  }

  public void setStudentID2(int studentID2)
  {
    this.studentID2 = studentID2;
  }

  public Instant getExpectedStartTime()
  {
    return expectedStartTime;
  }

  public void setExpectedStartTime(Instant expectedStartTime)
  {
    this.expectedStartTime = expectedStartTime;
  }

  public void setExpectedStartTime(final Timestamp expectedStartTime)
  {
    if (expectedStartTime != null)
    {
      this.expectedStartTime = expectedStartTime.toInstant();
    }
  }

  public int getExpectedDuration()
  {
    return expectedDuration;
  }

  public void setExpectedDuration(int duration)
  {
    this.expectedDuration = duration;
  }

  public long getZoomID()
  {
    return zoomID;
  }

  public void setZoomID(long id)
  {
    this.zoomID = id;
  }

  public String getZoomLink()
  {
    return zoomLink;
  }

  public void setZoomLink(String zoomLink)
  {
    this.zoomLink = zoomLink;
  }


}
