package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private long timeEntryId = 0;
    private HashMap<Long, TimeEntry> listOfTimeEntries;

    public InMemoryTimeEntryRepository() {
        listOfTimeEntries = new HashMap<>();
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(++timeEntryId);
        listOfTimeEntries.put(timeEntryId, timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return listOfTimeEntries.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(listOfTimeEntries.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {

        if (!listOfTimeEntries.containsKey(id)){
            return null;
        } else {
            timeEntry.setId(id);
            listOfTimeEntries.put(id, timeEntry);
            return timeEntry;
        }
    }

    @Override
    public void delete(long timeEntryId) {
        listOfTimeEntries.remove(timeEntryId);
    }
}
