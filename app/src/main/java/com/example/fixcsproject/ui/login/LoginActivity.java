package com.example.fixcsproject.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fixcsproject.R;
import com.example.fixcsproject.laundryapp.model.UserAccount;
import com.example.fixcsproject.laundryapp.view.LaundryAppMain;

public class LoginActivity extends Activity {

    private EditText username;
    private EditText password;
    private TextView attempts;
    private TextView loginActivityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        //attempts = findViewById(R.id.textView_attemt_Count); // Assuming this ID exists
        Button login_btn = findViewById(R.id.login);
        Button register_btn = findViewById(R.id.createAccount);
        loginActivityTextView = findViewById(R.id.LoginActivity);

        //attempts.setText(String.valueOf(attempt_counter));

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = username.getText().toString();
                String enteredPassword = password.getText().toString();

                UserDatabase userDatabase = UserDatabase.getInstance();
                UserAccount foundUser = null;
                for (UserAccount user : userDatabase.getAllUsers()) {
                    if (user.getName().equals(enteredUsername)) {
                        foundUser = user;
                        break;
                    }
                }

                if (foundUser != null && foundUser.getPasswordHash().equals(enteredPassword)) {
                    userDatabase.setSessionUser(foundUser);
                    Intent intent = new Intent(LoginActivity.this, UserTabRequestActivity.class);
                    startActivity(intent);
                } else {
                    loginActivityTextView.setText("DEBUG: FAIL - Invalid username or password.");
                }
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


}
