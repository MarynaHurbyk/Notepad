package com.mh.notepad.record;

import java.util.HashMap;
import java.util.List;

public class RecordDAO {
    private static int id = 1;


    public static HashMap<String, List<Record>> records = new HashMap<>();

    public void createRecord(String login,String theme, String text) {

        Record record = new Record();
        record.setId(id++);
        record.setTheme(theme);
        record.setText(text);
        records.get(login).add(record);
    }

    public List<Record> getRecordsByLogin(String login) {
        return records.get(login);
    }

    public Record getRecordsById(int id, List<Record> recordsList) {
        for (int i = 0; i < recordsList.size(); i++) {
            if (recordsList.get(i).getId() == id) {
                return recordsList.get(i);
            }
        }
        return null;
    }

    public void updateRecord(String login, int id, String theme, String text) {
        List<Record> recordsList = getRecordsByLogin(login);
        Record record = getRecordsById(id, recordsList);
        record.setTheme(theme);
        record.setText(text);
    }

    public void removeRecord(String login, int id) {
        List<Record> recordsList = getRecordsByLogin(login);
        Record record = getRecordsById(id, recordsList);
        recordsList.remove(record);
    }
}
