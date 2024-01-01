package org.assistments.vts.web;

import org.assistments.domain.exception.NotFoundException;
import org.assistments.vts.manager.LoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController
{
  @Autowired
  private LoginManager loginMger;

  public static class AuthorizationReturnBody
  {
    Boolean auth;
    int userID;
    String userName;
    private int userRole;

    public AuthorizationReturnBody(Boolean auth, int userID, String userName, int userRole)
    {
      this.auth     = auth;
      this.userID   = userID;
      this.userName = userName;
      this.userRole  = userRole;
    }

    public Boolean getAuth()
    {
      return this.auth;
    }

    public void setAuth(Boolean auth)
    {
      this.auth = auth;
    }

    public int getUserID()
    {
      return this.userID;
    }

    public void setUserID(int userID)
    {
      this.userID = userID;
    }

    public String getUserName()
    {
      return this.userName;
    }

    public void setUserName(String userName)
    {
      this.userName = userName;
    }

    public int getUserRole()
    {
      return this.userRole;
    }

    public void setUserRole(int userRole)
    {
      this.userRole = userRole;
    }
  }

  @RequestMapping(value = "/isAuth", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public AuthorizationReturnBody isAuth() throws NotFoundException
  {
    return loginMger.isAuth();
  }
}
