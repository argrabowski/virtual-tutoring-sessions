package org.assistments.vts.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assistments.service.dao.base.CommonDao;
import org.assistments.service.dao.base.DaoField;
import org.assistments.service.dao.base.RelationalOpType;
import org.assistments.service.dao.base.impl.NVPair;
import org.assistments.service.dao.base.impl.QueryTerm;
import org.assistments.service.dao.impl.DbDataType;
import org.assistments.util.Pair;
import org.assistments.vts.domain.MeetingLogInfo;

import com.google.common.collect.ImmutableList;

public interface MeetingLogInfoAbstractDao extends CommonDao<MeetingLogInfo>
{
  enum Field implements DaoField
  {
    ID(DbDataType.PK, FieldModifier.PRIMARY_KEY, FieldModifier.REQUIRED),

    MEETING_ID(DbDataType.INTEGER, ImmutableList.of(new Pair<>(FieldModifier.REFERENCES, "meeting_info(id)")),
        FieldModifier.REQUIRED),

    ZOOM_RECORDING(DbDataType.TEXT, FieldModifier.REQUIRED),

    COMMENT(DbDataType.TEXT, FieldModifier.OPTIONAL);

    private DbDataType dataType;
    private List<Pair<FieldModifier, String>> modifierPairs;
    public String name;
    public FieldModifier[] modifiers;

    private static final List<Pair<FieldModifier, String>> noModifierPairs = new ArrayList<>();

    private Field(DbDataType dataType, FieldModifier... modifiers)
    {
      this.dataType = dataType;
      this.modifiers = modifiers;
      this.name = this.name().toLowerCase();
    }

    Field(DbDataType dataType, List<Pair<FieldModifier, String>> modifierPairs, FieldModifier... modifiers)
    {
      this(dataType, modifiers);
      this.modifierPairs = modifierPairs;
    }

    @Override
    public String getName()
    {
      return this.name;
    }

    @Override
    public DbDataType getDbDataType()
    {
      return this.dataType;
    }

    @Override
    public FieldModifier[] getModifiers()
    {
      return this.modifiers;
    }

    @Override
    public List<Pair<FieldModifier, String>> getFieldModifierPairs()
    {
      if (this.modifierPairs == null)
      {
        return noModifierPairs;
      }

      return this.modifierPairs;
    }

    @Override
    public QueryTerm getQueryTerm(Object value)
    {
      return new QueryTerm(this, value);
    }

    @Override
    public QueryTerm getQueryTerm(RelationalOpType op, Object value)
    {
      return new QueryTerm(this, op, value);
    }

    @Override
    public NVPair getNVPair(Object value)
    {
      return new NVPair(this, value);
    }
  }

  static final String TableName = "meeting_log_info";

  static final Set<String> MultiFieldConstraints = new HashSet<>(Arrays.asList(
  ));

  static final Set<Pair<String, String>> TableConstraints = new HashSet<>(Arrays.asList(
  ));

  static final Set<String> AdditionalSQLs = new HashSet<>(Arrays.asList(
  ));

  static final Set<DaoField> UserXids = new HashSet<>(Arrays.asList(
  ));
}
