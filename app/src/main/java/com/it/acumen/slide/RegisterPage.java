package com.it.acumen.slide;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterPage extends AppCompatActivity {
    private EditText username;
    private EditText userpassword;
    private EditText useremail;
    private Button rbtn;
    private EditText raddress;
    private EditText rphno;
    public EditText rdob;
    private FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    DatabaseReference myref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        setupviews();
        database=FirebaseDatabase.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();
        rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate())
                {
                    String child=username.getText().toString();
                    myref=database.getReference("users").child(child);
                    myref.child("name").setValue(username.getText().toString());
                    myref.child("email").setValue(useremail.getText().toString());
                    myref.child("password").setValue(userpassword.getText().toString());
                    myref.child("collegename").setValue(raddress.getText().toString());
                    myref.child("phno").setValue(rphno.getText().toString());
                    myref.child("dob").setValue(rdob.getText().toString());
                    String user_email=useremail.getText().toString().trim();
                    String user_pass=userpassword.getText().toString().trim();


                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(RegisterPage.this,"registration succesfull",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(RegisterPage.this,"registration failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


            }
        });
    }
    private boolean validate()
    {
        boolean res=false;
        String name=username.getText().toString();
        String password=userpassword.getText().toString();
        String email=useremail.getText().toString();
        if(name.isEmpty()&&password.isEmpty()&&email.isEmpty())
        {
            Toast.makeText(this,"enter all details",Toast.LENGTH_SHORT).show();
        }
        else
        {
            res=true;
        }
        return res;
    }
    private void setupviews(){
        username=(EditText)findViewById(R.id.r_name);
        userpassword=(EditText)findViewById(R.id.r_password);
        useremail=(EditText)findViewById(R.id.r_email);
        raddress=(EditText)findViewById(R.id.clg);
        rphno=(EditText)findViewById(R.id.r_phone);
        rbtn=(Button)findViewById(R.id.r_button);
        rdob=(EditText)findViewById(R.id.r_dob);
    }
}
