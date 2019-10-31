package com.example.plainolnotes.database;

import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {
    // insert note
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(NoteEntity noteEntity);

    // intert list of notes
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<NoteEntity> notes);

    // delete note
    @Delete
    void deleteNote(NoteEntity noteEntity);

    // get note by id
    @Query("SELECT * FROM notes WHERE id = :id")
    NoteEntity getNoteById(int id);

    // get all notes by newest first
    @Query("SELECT * FROM notes ORDER BY date DESC")
    LiveData<List<NoteEntity>> getAll();

    // delete all notes
    @Query("DELETE FROM notes")
    int deleteAll();

    // get note count
    @Query("SELECt COUNT(*) FROM notes")
    int getCount();
}
