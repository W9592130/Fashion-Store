package com.example.fashionstore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FsMen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.men);

        ImageView a = findViewById(R.id.imageView19);
        a.setOnClickListener(task->{
            Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show();
        });
        ImageView b = findViewById(R.id.imageView21);
        b.setOnClickListener(task->{
            Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show();
        });
        ImageView c = findViewById(R.id.imageView20);
        c.setOnClickListener(task->{
            Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show();
        });
        TextView txt2 = findViewById(R.id.textView34);
        txt2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                String x = txt2.getText().toString();
                txt2.setBackgroundColor(R.color.purple_200);
            }
        });
    }
}
