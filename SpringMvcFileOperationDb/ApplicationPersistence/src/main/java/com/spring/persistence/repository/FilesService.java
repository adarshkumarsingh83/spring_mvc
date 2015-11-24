package com.spring.persistence.repository;


import com.spring.persistence.domain.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/9/12 11:16 AM#$
 */

@Service
public class FilesService extends JdbcDaoSupport {

    private static final Logger logger = LoggerFactory.getLogger(FilesService.class);

    /**
     * find
     */
    public Files find(int id) {
      final String query = "select * from files where id = ?";

        try {
            Files file = (Files) getJdbcTemplate().queryForObject(query, new Object[]{id},
                    new RowMapper() {
                        Files fl;

                        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                            fl = new Files();
                            fl.setId(rs.getInt(1));
                            fl.setFilename(rs.getString(2));
                            fl.setNotes(rs.getString(3));
                            fl.setType(rs.getString(4));
                            fl.setFile(rs.getBytes(5));

                            return fl;
                        }
                    });

            return file;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

    /**
     * listAll
     */
    public List<Files> listAll() throws Exception {
        final String  query = "select id, filename, notes, type from files";
        try {
            final List<Files> files = getJdbcTemplate().query(query, new BeanPropertyRowMapper(Files.class));
            return files;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * save
     */
    public void save(final Files file) throws Exception {
        final String  query = "insert into files (filename, notes, type, file) values (?, ?, ?, ?)";

        try {
            synchronized (this) {
                getJdbcTemplate().update(new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement statement = con.prepareStatement(query);
                        statement.setString(1, file.getFilename());
                        statement.setString(2, file.getNotes());
                        statement.setString(3, file.getType());
                        statement.setBytes(4, file.getFile());
                        return statement;
                    }
                });
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    /**
     * delete
     */
    public void delete(int id) throws Exception {
        final String  query = "delete from files where id = ?";
        try {
            getJdbcTemplate().update(query, new Object[]{id});
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }
}
