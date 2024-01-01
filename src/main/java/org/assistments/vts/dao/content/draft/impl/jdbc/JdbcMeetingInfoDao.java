package org.assistments.vts.dao.content.draft.impl.jdbc;

import org.assistments.service.dao.base.impl.jdbc.Jdbc;
import org.assistments.vts.dao.JdbcMeetingInfoAbstractDao;
import org.assistments.vts.dao.base.persisteddata.content.ContentTableType;
import org.springframework.stereotype.Repository;

@Repository
@Jdbc
public class JdbcMeetingInfoDao extends JdbcMeetingInfoAbstractDao
{
  protected JdbcMeetingInfoDao()
  {
    super(ContentTableType.MEETING_INFO);
  }
}
