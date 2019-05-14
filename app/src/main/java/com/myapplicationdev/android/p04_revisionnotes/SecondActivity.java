package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//TODO implement the Custom ListView

		lv = findViewById(R.id.lv);

		DBHelper db = new DBHelper(this);

		ArrayList<Note> noteList = new ArrayList<>();
		noteList = db.getAllNotes();
		RevisionNotesArrayAdapter rnna = new RevisionNotesArrayAdapter(this, R.layout.row, noteList);
		lv.setAdapter(rnna);


	}


}
