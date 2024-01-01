package org.assistments.vts.manager;

import org.assistments.domain.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component
public interface VtsAdminManager
{
  public Boolean userIsAdmin() throws NotFoundException;
}
