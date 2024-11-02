package com.example.mainactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DeleteNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note); // Убедитесь, что layout указан правильно

        ListView listView = findViewById(R.id.listViewDelete);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainActivity.notes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Удаление выбранной заметки и обновление списка
                MainActivity.notes.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(DeleteNoteActivity.this, "Note Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


