package com.example.fashionstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Products extends AppCompatActivity {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);

        TextView order = findViewById(R.id.textView41);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePayment();
                String Email = mAuth.getCurrentUser().getEmail();

                Map<String, Object> data = new HashMap<>();
                data.put("Product Name", "Lahenga");
                data.put("Product Price", "$890");
                data.put("Product Count", "1");
                data.put("Order at", "London");

                db.collection("FS_Orders").document(Email)
                        .set(data).addOnCompleteListener(
                                task ->
                                {

                                }
                        ).addOnFailureListener(
                                task -> {

                                }
                        );

            }
        });
    }

    private void changePayment() {
        Toast.makeText(this, "Payment Done", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,FsPayment.class);
        startActivity(i);
    }
}
