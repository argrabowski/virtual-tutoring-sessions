package org.assistments.vts.web;

import org.assistments.service.web.IControllerHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirect")
public class RedirectContoller
{
  private final IControllerHelper cHelper;

  public RedirectContoller(IControllerHelper cHelper)
  {
    this.cHelper = cHelper;
  }

  @RequestMapping("/returnToLocalhost")
  public String redirectToLocalHost()
  {
    // Place to redirect after logging in
    return cHelper.doRedirect("http://localhost:8080");
  }
}
