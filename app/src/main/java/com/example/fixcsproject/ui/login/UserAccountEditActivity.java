package com.example.fixcsproject.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fixcsproject.R;
import com.example.fixcsproject.laundryapp.controller.UserController;
import com.example.fixcsproject.laundryapp.model.UserAccount;

public class UserAccountEditActivity extends Activity {

    private UserController userController;
    private UserAccount sessionUser;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.useraccountedit);

        // You'll need to initialize userController and sessionUser appropriately here

        Button submit = findViewById(R.id.submituserinfochange);
        Button cancel = findViewById(R.id.canceluserinfochange);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText newUsername = findViewById(R.id.useridchange);
                EditText newPassword = findViewById(R.id.registerpasswordchange);
                EditText confirmNewPassword = findViewById(R.id.registerpasswordchangeconfirm);
                EditText newEmail = findViewById(R.id.useremailchange);
                EditText currentPassword = findViewById(R.id.currentpassword);

                if (currentPassword.getText().toString().equals(sessionUser.getPassword())) {
                    String username = newUsername.getText().toString();
                    String password = newPassword.getText().toString();
                    String email = newEmail.getText().toString();

                    if (!password.equals(confirmNewPassword.getText().toString())) {
                        // Handle password mismatch error
                        TextView temp = findViewById(R.id.wrongpassword);
                        temp.setText("New passwords do not match.");
                        return;
                    }

                    if (!username.isEmpty()) {
                        if (userController.getUser(username) == null) {
                            sessionUser.setUsername(username);
                        } else {
                            TextView temp = findViewById(R.id.wrongpassword);
                            temp.setText("Username already exists.");
                        }
                    }
                    if (!password.isEmpty()) {
                        sessionUser.setPassword(password);
                    }
                    if (!email.isEmpty()) {
                        sessionUser.setEmail(email);
                    }
                }

                Intent intent = new Intent(UserAccountEditActivity.this, UserTabAccountActivity.class);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserAccountEditActivity.this, UserTabAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}
