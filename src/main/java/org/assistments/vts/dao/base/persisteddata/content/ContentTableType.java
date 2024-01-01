package org.assistments.vts.dao.base.persisteddata.content;

import java.util.Locale;

import org.assistments.service.dao.base.SchemaType;
import org.assistments.service.dao.base.TableReplicationType;
import org.assistments.service.dao.base.TableType;
import org.assistments.service.dao.base.impl.TableTypeImpl;
import org.assistments.service.dao.base.persisteddata.PersistedDataList;
import org.assistments.vts.dao.content.draft.MeetingInfoDao;
import org.assistments.vts.dao.content.draft.MeetingLogInfoDao;

public class ContentTableType implements PersistedDataList
{
  public enum ContentSchemaType implements SchemaType
  {
    VTS;

    @Override
    public String getName()
    {
      return this.name().toLowerCase(Locale.ROOT);
    }
  }

  public static TableType MEETING_INFO =
      new TableTypeImpl(ContentSchemaType.VTS, TableReplicationType.NONE, MeetingInfoDao.class);

  public static TableType MEETING_LOG_INFO =
      new TableTypeImpl(ContentSchemaType.VTS, TableReplicationType.NONE, MeetingLogInfoDao.class);
}
