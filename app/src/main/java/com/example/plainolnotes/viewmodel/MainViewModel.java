package com.example.plainolnotes.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.plainolnotes.database.AppRepository;
import com.example.plainolnotes.database.NoteEntity;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public List<NoteEntity> mNotes;
    private AppRepository mRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mRepository = AppRepository.getInstance(application.getApplicationContext());
        mNotes = mRepository.mNotes;
    }

    public void addSampleData() {
        mRepository.addSampleData();
    }
}