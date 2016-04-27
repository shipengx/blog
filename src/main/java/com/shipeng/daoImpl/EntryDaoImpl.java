package com.shipeng.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import com.shipeng.dao.EntryDao;
import com.shipeng.model.Entry;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class EntryDaoImpl implements EntryDao {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource   = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
	
	public void saveOrUpdate(Entry entry) {
		//implementation details goes here.
        if (entry.getId() > 0) {
            //update
            String sql = "UPDATE Entry set title=?, text=?, posted_timestamp=?, category=? where id = ? ";
            jdbcTemplate.update(sql, entry.getTitle(), entry.getText(), entry.getPosted_timestamp(), entry.getCategory(), entry.getId());
        }else {
            //insert
            String sql = "INSERT INTO Entry (title, text, posted_timestamp, category) values (?, ?, ?, ?)";
            jdbcTemplate.update(sql, entry.getTitle(), entry.getText(), entry.getPosted_timestamp(), entry.getCategory());
        }
	}
		
	public void delete(int entryId) {
		// implementation details goes here...
        String sql = "DELETE FROM Entry where id = ?";
        jdbcTemplate.update(sql, entryId);
	}
	
	public List<Entry> listEntry() {
		//implementation details goes here...
		String sql = "Select * from Entry";
		List<Entry> listEntry = jdbcTemplate.query(sql, new RowMapper<Entry>() {
			
			public Entry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Entry entry = new Entry();
				entry.setId(rs.getInt("id"));
				entry.setTitle(rs.getString("title"));	
				entry.setText(rs.getString("text"));
				entry.setPosted_timestamp(rs.getInt("posted_timestamp"));
				entry.setCategory(rs.getInt("category"));
				return entry;
			}
		});
		
		return listEntry;	
	}//end listEntry
	
	public Entry getEntryById(int entryId) {
		//implementation details goes here...
		String sql = "select * from Entry where id = " + entryId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Entry>() {
			
			public Entry extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Entry entry = new Entry();
					entry.setId(rs.getInt("id"));
					entry.setTitle(rs.getString("title"));
					entry.setText(rs.getString("text"));
					entry.setPosted_timestamp(rs.getInt("posted_timestamp"));
					entry.setCategory(rs.getInt("category"));
					return entry;
				}
				return null;
			}
		});
	}
	
}//end class EntryDaoImpl




