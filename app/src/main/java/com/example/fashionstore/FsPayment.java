package com.example.fashionstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FsPayment extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        TextView order = findViewById(R.id.textView45);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changehome();

            }
        });
    }

    private void changehome() {
        finishAffinity();
        Intent i = new Intent(this,FsMain.class);
        startActivity(i);
    }
}

