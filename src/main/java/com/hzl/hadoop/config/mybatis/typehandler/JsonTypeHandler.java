package com.hzl.hadoop.config.mybatis.typehandler;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * description
 * https://blog.csdn.net/lmb55/article/details/90380309
 * 用于sql的json类型和java的json类型转换
 *
 * @author hzl 2022/02/16 9:25 AM
 */
@MappedTypes(JSON.class)
public class JsonTypeHandler extends BaseTypeHandler<JSON> {

	/**
	 * <p>
	 * 用户插入时将java类型转换成数据库类型
	 * </p>
	 * 
	 * @author hzl 2022/02/16 9:30 AM
	 */
	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, JSON json, JdbcType jdbcType) throws SQLException {

		//preparedStatement.set
	}

	@Override
	public JSON getNullableResult(ResultSet resultSet, String s) throws SQLException {
		return null;
	}

	@Override
	public JSON getNullableResult(ResultSet resultSet, int i) throws SQLException {
		return null;
	}

	@Override
	public JSON getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		return null;
	}
}
