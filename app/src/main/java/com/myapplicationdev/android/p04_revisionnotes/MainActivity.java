package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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

        buttonInsertNote.setOnClickListener((v)-> {
            DBHelper db = new DBHelper(MainActivity.this);

            if(editTextNote.toString().length() > 0){
                String note = editTextNote.getText().toString();
                int selectedButtonId = radioGroupStars.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButtonId);
                int rating = Integer.parseInt(rb.getText().toString());
                db.insertNote(note, rating);
                Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
                db.close();
            }
            else{
                Toast.makeText(this, "Enter Note's Name", Toast.LENGTH_SHORT).show();
            }

        });

        buttonShowList.setOnClickListener((v) ->{
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

    }
}
