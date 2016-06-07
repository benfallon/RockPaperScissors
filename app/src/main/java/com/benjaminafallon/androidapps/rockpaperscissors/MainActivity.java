package com.benjaminafallon.androidapps.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);

        setContentView(R.layout.activity_main);

        Firebase myFirebaseRef = new Firebase("https://glaring-fire-2159.firebaseio.com/");
        myFirebaseRef.child("message").setValue("Do you have data? You'll love Firebase.");

        myFirebaseRef.child("message").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.i("data value: ", "" + snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
            }

            @Override public void onCancelled(FirebaseError error) { }

        });

        final ImageView userChoiceImageView = (ImageView) findViewById(R.id.userChoiceImageView);

        Button rockButton = (Button) findViewById(R.id.rockButton);
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoiceImageView.setImageResource(R.drawable.rocklarge);
            }
        });
        Button paperButton = (Button) findViewById(R.id.paperButton);
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoiceImageView.setImageResource(R.drawable.paperlarge);
            }
        });
        Button scissorsButton = (Button) findViewById(R.id.scissorsButton);
        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoiceImageView.setImageResource(R.drawable.scissorslarge);
            }
        });




    }
}
