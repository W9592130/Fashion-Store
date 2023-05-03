package com.example.fashionstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FsSignup extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_fs);



        TextView txt3 = findViewById(R.id.txtSignup);
        EditText name = findViewById(R.id.sign_name);
        EditText email = findViewById(R.id.sign_email);
        EditText pass = findViewById(R.id.sign_pass);

        txt3.setOnClickListener(view -> {
            String Name = name.getText().toString();
            String Email = email.getText().toString();

            Map<String, Object> data = new HashMap<>();
            data.put("Name", Name);
            data.put("Email", Email);
            data.put("Mobile Number", "");
            data.put("Address", "California, USA, 100011");

            db.collection("FS_Users").document(Email)
                    .set(data).addOnCompleteListener(
                            task ->
                            {
                                change_main(email.getText().toString(), pass.getText().toString());
                            }
                    ).addOnFailureListener(
                            task -> {

                            }
                    );
        });

        TextView txt = findViewById(R.id.login);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change_login();
            }
        });
    }

    private void change_login() {
        Intent intent = new Intent(this, FsLogin.class);
        startActivity(intent);
    }

    private void change_main(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        finishAffinity();
                        Intent intent = new Intent(this, FsMain.class);
                        startActivity(intent);

                        Toast.makeText(getApplicationContext(), "Successfully created.",
                                Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(getApplicationContext(), "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
