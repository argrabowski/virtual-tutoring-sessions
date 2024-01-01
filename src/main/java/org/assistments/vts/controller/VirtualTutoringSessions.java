package org.assistments.vts.controller;

import javax.servlet.http.HttpServletRequest;
import org.assistments.domain.exception.NotFoundException;
import org.assistments.service.security.authorization.annotation.NeedsOneOfTheseAuthorities;
import org.assistments.vts.manager.MeetingLogManager;
import org.assistments.vts.manager.MeetingManager;
import org.assistments.vts.util.request.CreateMeetingLogRequest;
import org.assistments.vts.util.request.CreateMeetingRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("virtualtutoring")
public class VirtualTutoringSessions
{
  /**
   * The delegating manager used to handle the logic of any sent
   * request to this service.
   */
  private final MeetingManager mManager;
  private final MeetingLogManager mLManager;

  public VirtualTutoringSessions(final MeetingManager manager, final MeetingLogManager mLManager)
  {
    this.mManager = manager;
    this.mLManager = mLManager;
  }

  @NeedsOneOfTheseAuthorities("ADMIN")
  @GetMapping("getMeetings")
  public ResponseEntity<Object> getMeetings(HttpServletRequest request) throws NotFoundException
  {
    return new ResponseEntity<>(this.mManager.getMeetings(), HttpStatus.OK);
  }

  @NeedsOneOfTheseAuthorities("ADMIN")
  @PutMapping("createMeeting")
  public ResponseEntity<Object> createMeeting(HttpServletRequest request,
      @RequestBody final CreateMeetingRequest meetingRequest)
  {
    return new ResponseEntity<>(this.mManager.createMeeting(meetingRequest), HttpStatus.OK);
  }

  /**
   * Creates a meeting log after the meeting
   * @return the meeting log object
   */
  @NeedsOneOfTheseAuthorities("ADMIN")
  @GetMapping("createMeetingLog")
  public ResponseEntity<Object> getStudents(HttpServletRequest request,
      @RequestBody final CreateMeetingLogRequest meetingLogRequest)
  {
    return new ResponseEntity<>(this.mLManager.createMeetingLog(meetingLogRequest), HttpStatus.OK);
  }
}
