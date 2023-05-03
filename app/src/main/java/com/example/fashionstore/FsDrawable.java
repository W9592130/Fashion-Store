package com.example.fashionstore;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class FsDrawable extends AppCompatActivity {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.side_navigation);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(task->{
            mAuth.signOut();
            finishAffinity();
            Intent intent = new Intent(this, FsMain.class);
            startActivity(intent);
        });

    }
}
