package com.itkingk.hotel.api.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.geometric.PGpoint;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author kingk
 * @date 2020/4/20 0:08
 */
@MappedTypes(value = {PGpoint.class})
public class GeometryTypeHandler extends BaseTypeHandler<PGpoint> {
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, PGpoint parameter, JdbcType jdbcType) throws SQLException {
		parameter.setType("point");
		ps.setObject(i,parameter.getValue());
	}

	@Override
	public PGpoint getNullableResult(ResultSet rs, String columnName) throws SQLException {
		byte[] object = (byte[]) rs.getObject(columnName);
		PGpoint pGpoint = new PGpoint();
		pGpoint.setByteValue(object,0);
		return pGpoint;
	}

	@Override
	public PGpoint getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return (PGpoint) rs.getObject(columnIndex);
	}

	@Override
	public PGpoint getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return (PGpoint) cs.getObject(columnIndex);
	}
}
