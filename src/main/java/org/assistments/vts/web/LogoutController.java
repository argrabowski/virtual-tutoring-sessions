package org.assistments.vts.web;

import org.assistments.vts.web.LoginController.AuthorizationReturnBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class LogoutController
{
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public AuthorizationReturnBody logout()
  {
    return new AuthorizationReturnBody(false, -1, null, 0);
  }
}
