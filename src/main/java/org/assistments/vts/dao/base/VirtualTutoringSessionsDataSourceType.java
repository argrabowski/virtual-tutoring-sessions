package org.assistments.vts.dao.base;

import org.assistments.service.dao.base.DataSourceType;

public enum VirtualTutoringSessionsDataSourceType implements DataSourceType
{
  VTS;

  @Override
  public String getNickname()
  {
    return this.toString();
  }
}
