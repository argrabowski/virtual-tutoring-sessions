package org.assistments.vts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.assistments.service.dao.base.IsaAbstractJdbc;
import org.assistments.service.dao.base.TableType;
import org.assistments.service.dao.base.impl.JdbcHelper;
import org.assistments.service.dao.base.impl.NVPairList;
import org.assistments.service.dao.base.impl.jdbc.JdbcBaseDao;
import org.assistments.vts.dao.content.draft.MeetingInfoDao;
import org.assistments.vts.domain.MeetingInfo;
import org.springframework.jdbc.core.RowMapper;

public abstract class JdbcMeetingInfoAbstractDao extends JdbcBaseDao<MeetingInfo>
  implements MeetingInfoDao, IsaAbstractJdbc
{
  protected JdbcMeetingInfoAbstractDao(TableType tt)
  {
    super(tt);
  }

  @Override
  protected NVPairList getNVPairs(MeetingInfo obj)
  {
    NVPairList params = new NVPairList();

    params.addValue(MeetingInfoDao.Field.SUPERVISOR_ID, obj.getSupervisorID());
    params.addValue(MeetingInfoDao.Field.TUTOR_ID, obj.getTutorID());
    params.addValue(MeetingInfoDao.Field.STUDENT_ID1, obj.getStudentID1());
    params.addValue(MeetingInfoDao.Field.STUDENT_ID2, obj.getStudentID2());
    params.addValue(MeetingInfoDao.Field.EXPECTED_START_TIME,
        JdbcHelper.getSqlTimeStamp(obj.getExpectedStartTime()));
    params.addValue(MeetingInfoDao.Field.EXPECTED_DURATION, obj.getExpectedDuration());
    params.addValue(MeetingInfoDao.Field.ZOOM_ID, obj.getZoomID());
    params.addValue(MeetingInfoDao.Field.ZOOM_LINK, obj.getZoomLink());

    return params;
  }

  @Override
  protected RowMapper<MeetingInfo> getRowMapper()
  {
    RowMapper<MeetingInfo> rm = new RowMapper<MeetingInfo>()
    {
      @Override
      public MeetingInfo mapRow(ResultSet rs, int rowNum) throws SQLException
      {
        MeetingInfo domObj = new MeetingInfo();

        domObj.setId(rs.getInt(MeetingInfoDao.Field.ID.name));
        domObj.setSupervisorID(rs.getInt(MeetingInfoDao.Field.SUPERVISOR_ID.name));
        domObj.setTutorID(rs.getInt(MeetingInfoDao.Field.TUTOR_ID.name));
        domObj.setStudentID1(rs.getInt(MeetingInfoDao.Field.STUDENT_ID1.name));
        domObj.setStudentID2(rs.getInt(MeetingInfoDao.Field.STUDENT_ID2.name));
        domObj.setExpectedStartTime(rs.getTimestamp(MeetingInfoDao.Field.EXPECTED_START_TIME.name));
        domObj.setExpectedDuration(rs.getInt(MeetingInfoDao.Field.EXPECTED_DURATION.name));
        domObj.setZoomID(rs.getLong(MeetingInfoDao.Field.ZOOM_ID.name));
        domObj.setZoomLink(rs.getString(MeetingInfoDao.Field.ZOOM_LINK.name));

        return domObj;
      }
    };

    return rm;
  }
}
