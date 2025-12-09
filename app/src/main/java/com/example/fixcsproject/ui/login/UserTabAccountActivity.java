package com.example.fixcsproject.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fixcsproject.R;

public class UserTabAccountActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usertabaccount);

        Button accountButton = findViewById(R.id.RequestButton);

        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserTabAccountActivity.this, UserTabRequestActivity.class);
                startActivity(intent);
            }
        });

        Button employeeSignupButton = findViewById(R.id.EmployeeSignupButton);

        employeeSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserTabAccountActivity.this, EmployeeTabAccountActivity.class);
                startActivity(intent);
            }
        });

        Button changeAccountInfo = findViewById(R.id.editAccountButton);

        changeAccountInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserTabAccountActivity.this, UserAccountEditActivity.class);
                startActivity(intent);
            }
        });
    }
}
