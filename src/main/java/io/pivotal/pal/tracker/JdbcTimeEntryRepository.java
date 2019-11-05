package io.pivotal.pal.tracker;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTimeEntryRepository implements TimeEntryRepository {

    private JdbcTemplate jdbcTemplate;
    private final String TABLE_NAME = "time_entries";

    public JdbcTimeEntryRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        String sql = "INSERT INTO " + TABLE_NAME + " (" +
                " project_id," +
                " user_id," +
                " date," +
                " hours) " +
                "VALUES (?, ?, ?, ?)";

        Object[] params = new Object[] {
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        };

        jdbcTemplate.update(sql, params);

        return timeEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, Object[]{timeEntryId});
    }

    @Override
    public List<TimeEntry> list() {
        return null;
    }

    @Override
    public TimeEntry update(long eq, TimeEntry any) {
        return null;
    }

    @Override
    public void delete(long timeEntryId) {

    }
}
