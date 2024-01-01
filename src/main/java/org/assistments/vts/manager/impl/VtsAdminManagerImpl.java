package org.assistments.vts.manager.impl;

import java.util.Set;
import org.assistments.domain.core.User;
import org.assistments.domain.exception.NotFoundException;
import org.assistments.service.manager.core.RolesManager;
import org.assistments.service.security.authentication.core.AuthenticationHolder;
import org.assistments.service.security.authentication.core.GrantedAuthority;
import org.assistments.service.security.authorization.GlobalRoleType;
import org.assistments.vts.manager.VtsAdminManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VtsAdminManagerImpl implements VtsAdminManager
{
  @Autowired
  private RolesManager rolesMgr;

  @Override
  public Boolean userIsAdmin() throws NotFoundException
  {
    User user = AuthenticationHolder.getCurrentUser();
    Set<GrantedAuthority> userRoles = rolesMgr.getUserRoles(user.getXrefObj().getXinfo());
    return userRoles.contains(GlobalRoleType.PARTNER_ADMIN.getGrantedAuthority());
  }
}
