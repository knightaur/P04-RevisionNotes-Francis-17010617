package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button buttonInsertNote;
    Button buttonShowList;
    EditText editTextNote;
    RadioGroup radioGroupStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonInsertNote = findViewById(R.id.buttonInsertNote);
        buttonShowList = findViewById(R.id.buttonShowList);
        editTextNote = findViewById(R.id.editTextNote);
        radioGroupStars = findViewById(R.id.radioGroupStars);


            buttonInsertNote.setOnClickListener((v) -> {

                if(editTextNote.getText().toString().length() > 0) {
                    DBHelper db = new DBHelper(MainActivity.this);
                    ArrayList<String> existing = db.getNoteContent();
                    boolean exist = false;

                    String note = editTextNote.getText().toString();
                    int selectedButtonId = radioGroupStars.getCheckedRadioButtonId();
                    RadioButton rb = findViewById(selectedButtonId);
                    int rating = Integer.parseInt(rb.getText().toString());

                    for (int i = 0; i < existing.size(); i++) {
                        if(note.equalsIgnoreCase(existing.get(i))){
                            exist = true;
                        }
                    }

                    if(exist){
                        Toast.makeText(this, "Existing Data", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        db.insertNote(note, rating);
                        Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
                        db.close();
                    }
                }
                else{
                    Toast.makeText(this, "Enter Note", Toast.LENGTH_SHORT).show();
                }
            });


        buttonShowList.setOnClickListener((v) ->{
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

    }
}
