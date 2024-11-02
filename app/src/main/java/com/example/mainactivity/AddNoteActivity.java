package com.example.mainactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {
    private EditText noteName, noteContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note); // Убедитесь, что layout указан правильно

        noteName = findViewById(R.id.noteName);
        noteContent = findViewById(R.id.noteContent);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noteName.getText().toString().isEmpty() || noteContent.getText().toString().isEmpty()) {
                    // Проверка на пустые поля и отображение предупреждения с Toast
                    Toast.makeText(AddNoteActivity.this, getString(R.string.empty_warning), Toast.LENGTH_SHORT).show();
                } else {
                    // Добавление заметки в список и закрытие активности
                    MainActivity.notes.add(noteName.getText().toString());
                    finish();
                }
            }
        });
    }
}

