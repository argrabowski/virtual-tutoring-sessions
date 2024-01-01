package org.assistments.vts.manager;

import org.assistments.domain.exception.NotFoundException;
import org.assistments.vts.web.LoginController.AuthorizationReturnBody;
import org.springframework.stereotype.Controller;

@Controller
public interface LoginManager
{
  public AuthorizationReturnBody isAuth() throws NotFoundException;
}
