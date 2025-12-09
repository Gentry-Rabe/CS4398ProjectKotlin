package com.example.fixcsproject.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fixcsproject.R;

public class EmployeeTabFindActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employeetabfind);

        Button employeeAccountButton = findViewById(R.id.EmployeeAccountButtonTabFind);

        employeeAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeTabFindActivity.this, EmployeeTabAccountActivity.class);
                startActivity(intent);
            }
        });

        Button employeeRequestButton = findViewById(R.id.EmployeeRequestButtonTabFind);

        employeeRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeTabFindActivity.this, EmployeeTabRequestActivity.class);
                startActivity(intent);
            }
        });
    }
}
