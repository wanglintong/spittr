package cn.com.zlqf.spittr.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cn.com.zlqf.spittr.entity.Spitter;

public class SpitterRowMapper implements RowMapper<Spitter>{

	@Override
	public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Spitter(rs.getString("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("username"),rs.getString("password"));
	}

}
