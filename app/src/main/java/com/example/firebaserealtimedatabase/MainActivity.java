package com.example.firebaserealtimedatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText NameEditText,AgeEditText;
    Button SaveButton;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NameEditText = findViewById(R.id.NameEditText);
        AgeEditText = findViewById(R.id.AgeEditText);
        SaveButton = findViewById(R.id.SaveButton);
        databaseReference = FirebaseDatabase.getInstance().getReference("referenceName");
        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

    }

    public void saveData() {
        String name = NameEditText.getText().toString();
        String Age = AgeEditText.getText().toString();
        //uniquely identifies data by setting a primary key/unique key
        String key = databaseReference.push().getKey();
        Student student = new Student(name,Age);
        //.child creates new child to store data in firebase!

        databaseReference.child(key).setValue(student);
        Toast.makeText(getApplicationContext(),"Sucessfully stored",Toast.LENGTH_SHORT).show();


    }

}

