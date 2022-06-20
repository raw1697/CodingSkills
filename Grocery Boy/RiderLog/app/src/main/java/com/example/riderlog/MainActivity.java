package com.example.riderlog;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

   // FirebaseFirestore db = FirebaseFirestore.getInstance();
    //private DocumentReference eDocRef = FirebaseFirestore.getInstance().document("rider/email");
    //private DocumentReference pDocRef = FirebaseFirestore.getInstance().document("rider/password");

    private TextView forgotPassword;
    private EditText email;
    private EditText password;
    private Button login;
    private Button signUp;

    private TextView Info;
    private ProgressDialog progressDialog;
    private int counter = 5;

    private ImageView image;


    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;

    //Toolbar varible.
   // private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creating instance of FirebaseAuth using the mAuth created in the field above.
        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        //mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
       //setSupportActionBar(mToolbar);
      //getSupportActionBar().setTitle("Grocery boy");

        image = (ImageView) findViewById(R.id.imageView);
        email = (EditText) findViewById(R.id.emailEt);
        password = (EditText) findViewById(R.id.passwordEt);
        login = (Button) findViewById(R.id.LoginBtn);
        signUp = (Button) findViewById(R.id.signUpBtn);
        Info = (TextView)findViewById(R.id.info);
        forgotPassword = (TextView) findViewById(R.id.forgottenPassTw);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                // if statement for if the user is logged in and if thats the case it will bring you to the second page
                if(firebaseAuth.getCurrentUser() != null){

                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                          startActivity(intent);
                          finish();

                }
            }
        };

        // sign up on click
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        // code for when the button is clicked
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // load startLogin method when the button is clicked.
              //  startLogin();
                validate(email.getText().toString(), password.getText().toString());
               // checkEmailVerification();

                forgotPassword.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, com.example.riderlog.passwordActivity.class));
                    }
                });
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthListener);
    }

    private void startLogin(){

        String emailAddress = email.getText().toString();
        String passW = password.getText().toString();

        if(TextUtils.isEmpty(emailAddress) || TextUtils.isEmpty(passW)){
            Toast.makeText(MainActivity.this, "fields are empty", Toast.LENGTH_LONG).show();

        }else {
            mAuth.signInWithEmailAndPassword(emailAddress, passW).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (!task.isSuccessful()) {

                        Toast.makeText(MainActivity.this, "sign in properly", Toast.LENGTH_LONG).show();

                    }

                  //  checkEmailVerification();
                }
            });
        }
         // Intent intent = new Intent(MainActivity.this, ordersPage.class);
         // startActivity(intent);

    }


    private void validate(String userName, String userPassword){

        progressDialog.setMessage("Loading.");
        progressDialog.show();

        String emailAddress = email.getText().toString();
        String passW = password.getText().toString();

        if(TextUtils.isEmpty(emailAddress) || TextUtils.isEmpty(passW)) {
            Toast.makeText(MainActivity.this, "fields are empty", Toast.LENGTH_LONG).show();
        }else {

            mAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        finish();
                        //Toast.makeText(MainActivity.this, "Login Successful.", Toast.LENGTH_SHORT).show();
                        checkEmailVerification();
                        // startActivity(new Intent(MainActivity.this, SecondActivity.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Login Failed.", Toast.LENGTH_SHORT).show();
                        counter--;
                        Info.setText("No of attempts remaining: " + counter);
                        progressDialog.dismiss();
                        if (counter == 0) {
                            login.setEnabled(false);
                        }
                    }
                }
            });
        }

    }
    //check email
    private void checkEmailVerification(){
        FirebaseUser firebaseUser = mAuth.getInstance().getCurrentUser();
        Boolean emailFlag = firebaseUser.isEmailVerified();

        if(emailFlag){
            finish();
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
        }else{
            Toast.makeText(MainActivity.this, "Verify your email", Toast.LENGTH_SHORT).show();
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
        }

    }
    // To
    // Go this


}
