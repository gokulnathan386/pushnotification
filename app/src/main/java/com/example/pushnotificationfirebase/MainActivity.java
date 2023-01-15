package com.example.pushnotificationfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private EditText mTitle,mMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = findViewById(R.id.mTitle);
        mMessage = findViewById(R.id.mMessage);

        findViewById(R.id.mSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = mTitle.getText().toString().trim();
                String message = mMessage.getText().toString().trim();

                if(!mTitle.equals("") && !mMessage.equals("")){

                    FCMSend.pushNotification(MainActivity.this,"dOlNTWJUQjKawzSgR19210:APA91bFXNfhqDmlUXkivHFx7KpUVIeu512GqM80L2E8o-iXRKMTkXiKmBD2TOPKeP2pwedNBc4bT27zBqLBhpd529VJ2nEA3pTPMCz_LyS9RbcYfjRiQHusvRgXVZs1KyExxF0S6PT5U",title,message);

                }
            }
        });


        //Device Id
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            //Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }


                        // Get new FCM registration token
                        String token = task.getResult();

                      Log.d("Token--> "," " +token);

                    }
                });
    }
}