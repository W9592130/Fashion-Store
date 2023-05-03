package com.example.fashionstore;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class FsLogin extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    EditText edtMobile, edtPassword;
    ConstraintLayout imgCardMobile, imgCardPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_fs);

        TextView sign = findViewById(R.id.sign);
        sign.setOnClickListener(task->{
            Intent intent = new Intent(this, FsSignup.class);
            startActivity(intent);
        });

        edtMobile = findViewById(R.id.email);
        edtPassword = findViewById(R.id.password);
        TextView login = findViewById(R.id.txtLogin);

        login.setOnClickListener(task->{
            mAuth.signInWithEmailAndPassword(edtMobile.getText().toString(), edtPassword.getText().toString())
                    .addOnCompleteListener(
                            task1->{
                                finishAffinity();
                                Intent home = new Intent(this, FsMain.class);

                                startActivity(home);
                                Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                            }
                    ).addOnFailureListener(
                            task2->{
                                Toast.makeText(this, "Authentication Falied", Toast.LENGTH_SHORT).show();
                            }
                    );
        });



    }
}
