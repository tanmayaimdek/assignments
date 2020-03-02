package com.aimdek.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.aimdek.employee.beans.emp;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class empDao {
	private JdbcTemplate jdbcTemplate;

	public empDao() {

	}

	public empDao(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	public void saveOrUpdate(emp contact) {
		if (contact.getId() > 0) {
			// update
			String sql = "UPDATE contact SET name=?, email=?, telephone=? WHERE contact_id=?";
			jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
					contact.getTelephone(), contact.getId());
		} else {
			// insert
			String sql = "INSERT INTO contact (name, email, telephone) VALUES (?, ?, ?)";
			jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
					contact.getTelephone());
		}

	}

	public void delete(int contactId) {
		String sql = "DELETE FROM contact WHERE contact_id=?";
		jdbcTemplate.update(sql, contactId);
	}

	public List<emp> list() {
		String sql = "SELECT * FROM contact";
		System.out.println("i m called");
		List<emp> listContact = jdbcTemplate.query(sql, new RowMapper<emp>() {

			@Override
			public emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				emp aContact = new emp();

				aContact.setId(rs.getInt("contact_id"));
				aContact.setName(rs.getString("name"));
				aContact.setEmail(rs.getString("email"));
				aContact.setTelephone(rs.getString("telephone"));

				return aContact;
			}

		});

		return listContact;
	}

	public emp get(int contactId) {

		String sql = "SELECT * FROM contact WHERE contact_id=" + contactId;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<emp>() {
	 
	        @Override
	        public emp extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                emp contact = new emp();
	                contact.setId(rs.getInt("contact_id"));
	                contact.setName(rs.getString("name"));
	                contact.setEmail(rs.getString("email"));
	                contact.setTelephone(rs.getString("telephone"));
	                return contact;
	            }
	 
	            return null;
	        }
	 
	    });	}

}
