package com.example.fixcsproject.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fixcsproject.R;
import com.example.fixcsproject.laundryapp.model.UserAccount;

import java.util.UUID;

public class RegisterActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        EditText emailEditText = findViewById(R.id.useremail);
        EditText usernameEditText = findViewById(R.id.userid);
        EditText passwordEditText = findViewById(R.id.registerpassword);
        EditText confirmPasswordEditText = findViewById(R.id.confirmpassword);

        TextView registerActivityTextView = findViewById(R.id.RegisterActivity);

        Button register_btn = findViewById(R.id.registerAccount);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                if (password.equals(confirmPassword)) {
                    UserDatabase userDatabase = UserDatabase.getInstance();
                    boolean userExists = false;
                    for (UserAccount user : userDatabase.getAllUsers()) {
                        if (user.getEmail().equals(email) || user.getName().equals(username)) {
                            userExists = true;
                            break;
                        }
                    }

                    if (userExists) {
                        registerActivityTextView.setText("ERROR: Email or Username already exists.");
                    } else {
                        String newUserId = UUID.randomUUID().toString();
                        UserAccount newUser = new UserAccount(newUserId, username, email, password, "", null, null);
                        userDatabase.addUser(newUser);

                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                } else {
                    registerActivityTextView.setText("ERROR: Passwords do not match.");
                }
            }
        });
    }
}
