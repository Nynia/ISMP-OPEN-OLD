package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.mysql.jdbc.Statement;

public class DBUtil
{
	/**
	 * 获取写入数据条目的主键�?
	 * 
	 * @param jdbcTemplate
	 * @param sql
	 * @param params
	 * @return 主键�?
	 * @throws Exception
	 */
	public static int getPrimaryKeyAfterInsertToDB(JdbcTemplate jdbcTemplate, final String sql, final Object... params) throws Exception
	{
		final KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator()
		{
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException
			{
				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				// 写入参数
				for (int i = 0; i < params.length; i++)
				{
					ps.setObject(i + 1, params[i]);
				}

				return ps;
			}
		}, keyHolder);

		// 返回写入数据条目的主键�?
		return keyHolder.getKey().intValue();
	}
}
