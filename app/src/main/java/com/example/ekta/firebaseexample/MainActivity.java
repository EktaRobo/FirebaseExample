package com.example.ekta.firebaseexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mName;
    private DatabaseReference mDatabaseReference;
    private TextView mAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mName = (TextView) findViewById(R.id.name);
        mAge = (TextView) findViewById(R.id.age);
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               /* String data = "Name: " + dataSnapshot.getValue().toString();
                mName.setText(data);*/
                Model model = dataSnapshot.getValue(Model.class);
                Log.e(TAG, "onDataChange:" + model.toString() );
                String name = "Name: " + model.getName();
                mName.setText(name);
                String age = "Age: " + model.getAge();
                mAge.setText(age);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Some error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
