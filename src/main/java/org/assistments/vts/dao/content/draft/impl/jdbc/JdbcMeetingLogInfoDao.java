package org.assistments.vts.dao.content.draft.impl.jdbc;

import org.assistments.service.dao.base.impl.jdbc.Jdbc;
import org.assistments.vts.dao.JdbcMeetingLogInfoAbstractDao;
import org.assistments.vts.dao.base.persisteddata.content.ContentTableType;
import org.springframework.stereotype.Repository;

@Repository
@Jdbc
public class JdbcMeetingLogInfoDao extends JdbcMeetingLogInfoAbstractDao
{
  protected JdbcMeetingLogInfoDao()
  {
    super(ContentTableType.MEETING_LOG_INFO);
  }
}
