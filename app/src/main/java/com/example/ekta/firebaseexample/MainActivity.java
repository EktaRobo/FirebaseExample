package com.example.ekta.firebaseexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private AppCompatEditText mEditText;
    private AppCompatEditText mEditText2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button firebaseButton = (Button) findViewById(R.id.firebase_btn);
        mEditText = (AppCompatEditText) findViewById(R.id.appCompatEditText);
        mEditText2 = (AppCompatEditText) findViewById(R.id.appCompatEditText2);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        firebaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1 - Create child in root object
                // 2 - Assign some value into the child object
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("Name", mEditText.getText().toString().trim());
                dataMap.put("Age", mEditText2.getText().toString().trim());

                mDatabase.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}
