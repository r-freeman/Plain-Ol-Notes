package com.example.plainolnotes;

import android.os.Bundle;

import com.example.plainolnotes.database.NoteEntity;
import com.example.plainolnotes.viewmodel.EditorViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.plainolnotes.utilities.Constants.NOTE_ID_KEY;

public class EditorActivity extends AppCompatActivity {

    @BindView(R.id.note_text)
    TextView mTextView;

    private EditorViewModel mViewModel;
    private boolean mNewNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        initViewModel();
    }

    private void initViewModel() {
        mViewModel = ViewModelProviders.of(this)
                .get(EditorViewModel.class);

        mViewModel.mLiveNote.observe(this, new Observer<NoteEntity>() {
            @Override
            public void onChanged(NoteEntity noteEntity) {
                mTextView.setText(noteEntity.getText());

            }
        });

        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            setTitle("New note");
            mNewNote = true;
        } else {
            setTitle("Edit note");
            int noteId = extras.getInt(NOTE_ID_KEY);
            mViewModel.loadData(noteId);
        }
    }
}
