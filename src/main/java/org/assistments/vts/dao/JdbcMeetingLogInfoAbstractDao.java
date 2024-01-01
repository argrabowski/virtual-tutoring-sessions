package org.assistments.vts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.assistments.service.dao.base.IsaAbstractJdbc;
import org.assistments.service.dao.base.TableType;
import org.assistments.service.dao.base.impl.NVPairList;
import org.assistments.service.dao.base.impl.jdbc.JdbcBaseDao;
import org.assistments.vts.dao.content.draft.MeetingLogInfoDao;
import org.assistments.vts.domain.MeetingLogInfo;
import org.springframework.jdbc.core.RowMapper;

public abstract class JdbcMeetingLogInfoAbstractDao extends JdbcBaseDao<MeetingLogInfo>
  implements MeetingLogInfoDao, IsaAbstractJdbc
{
  protected JdbcMeetingLogInfoAbstractDao(TableType tt)
  {
    super(tt);
  }

  @Override
  protected NVPairList getNVPairs(MeetingLogInfo obj)
  {
    NVPairList params = new NVPairList();

    params.addValue(MeetingLogInfoDao.Field.MEETING_ID, obj.getMeetingID());
    params.addValue(MeetingLogInfoDao.Field.ZOOM_RECORDING, obj.getZoomRecording());
    params.addValue(MeetingLogInfoDao.Field.COMMENT, obj.getComment());

    return params;
  }

  @Override
  protected RowMapper<MeetingLogInfo> getRowMapper()
  {
    RowMapper<MeetingLogInfo> rm = new RowMapper<MeetingLogInfo>()
    {
      @Override
      public MeetingLogInfo mapRow(ResultSet rs, int rowNum) throws SQLException
      {
        MeetingLogInfo domObj = new MeetingLogInfo();

        domObj.setId(rs.getInt(MeetingLogInfoDao.Field.ID.name));
        domObj.setMeetingID(rs.getInt(MeetingLogInfoDao.Field.MEETING_ID.name));
        domObj.setZoomRecording(rs.getString(MeetingLogInfoDao.Field.ZOOM_RECORDING.name));
        domObj.setComment(rs.getString(MeetingLogInfoDao.Field.COMMENT.name));

        return domObj;
      }
    };

    return rm;
  }
}
