package org.assistments.vts.dao.base.persisteddata.content;

import org.assistments.service.dao.base.TableType;
import org.assistments.service.dao.base.impl.PersistedDataSchemaImpl;
import org.assistments.vts.dao.base.VirtualTutoringSessionsDataSourceType;
import org.springframework.stereotype.Component;

@Component
public class ContentPersistableData extends PersistedDataSchemaImpl
{
  public ContentPersistableData()
  {
    super(VirtualTutoringSessionsDataSourceType.VTS, TableType.getValues(ContentTableType.class));
  }
}
