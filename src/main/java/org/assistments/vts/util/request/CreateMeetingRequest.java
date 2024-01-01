package org.assistments.vts.util.request;

import java.time.Instant;

public class CreateMeetingRequest
{
  private int supervisorID;
  private int tutorID;
  private int studentID1;
  private int studentID2;
  private Instant expectedStartTime;
  private int expectedDuration;

  public CreateMeetingRequest()
  {
    supervisorID = -1;
    tutorID = -1;
    studentID1 = -1;
    studentID2 = -1;
    expectedStartTime = Instant.now();
    expectedDuration = -1;
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

  public int getExpectedDuration()
  {
    return expectedDuration;
  }

  public void setExpectedDuration(int expectedDuration)
  {
    this.expectedDuration = expectedDuration;
  }


}
