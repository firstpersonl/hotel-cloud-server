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
 * PostGIS常用函数以及使用方法见<a>https://blog.csdn.net/u013420816/article/details/53727960</a>,<a href='http://postgis.net/install/'>PostGIS</a>
 * @author kingk
 * @date 2020/4/20 0:08
 */
@MappedTypes(value = {PGpoint.class})
public class GeometryTypeHandler extends BaseTypeHandler<PGpoint> {
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, PGpoint parameter, JdbcType jdbcType) throws SQLException {
		ps.setObject(i,"POINT("+ parameter.x +" "+ parameter.y +")");
	}

	@Override
	public PGpoint getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String pointStr = ((String) rs.getObject(columnName)).replace(" ", ",").replace("POINT","");
		return new PGpoint(pointStr);
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
