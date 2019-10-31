package com.example.plainolnotes.utilities;

import com.example.plainolnotes.database.NoteEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SampleData {
    private static final String SAMPLE_TEXT_1 = "Lorem ipsum dolor sit.";
    private static final String SAMPLE_TEXT_2 = "A note with a\nline feed.";
    private static final String SAMPLE_TEXT_3 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, s0ed do eiusmod tempor incididunt\n " +
            "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. \n" +
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.\n" +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    private static Date getDate(int diff) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(Calendar.MILLISECOND, diff);

        return cal.getTime();
    }

    public static List<NoteEntity> getNotes() {
        List<NoteEntity> notes = new ArrayList<>();
        notes.add(new NoteEntity(1, getDate(0), SAMPLE_TEXT_1));
        notes.add(new NoteEntity(2, getDate(-1), SAMPLE_TEXT_2));
        notes.add(new NoteEntity(3, getDate(-2), SAMPLE_TEXT_3));

        return notes;
    }
}
