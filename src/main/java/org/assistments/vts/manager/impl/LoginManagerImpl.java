package org.assistments.vts.manager.impl;

import org.assistments.domain.core.User;
import org.assistments.vts.manager.LoginManager;
import org.assistments.vts.web.LoginController.AuthorizationReturnBody;
import org.assistments.service.security.authentication.core.AuthenticationHolder;
import org.springframework.stereotype.Component;

@Component
public class LoginManagerImpl implements LoginManager
{
  public AuthorizationReturnBody isAuth()
  {

    if (!AuthenticationHolder.isAuthenticated())
    {
      return new AuthorizationReturnBody(false, -1, null, 0);
    }
    else
    {
      User authorizedUser = AuthenticationHolder.getCurrentUser();
      /*
       * User.getRoleId(): int
       * admin: 1, tutor: 2, teacher: 3, student: 4
       */
      return new AuthorizationReturnBody(
        true,
        authorizedUser.getId(),
        authorizedUser.getFirstName(),
        /* authorizedUser.getRoleId() */ 1);
    }
  }
}
