package com.example.fixcsproject.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.fixcsproject.R;

public class EmployeeTabRequestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employeetabrequest);

        Button employeeAccountButton = findViewById(R.id.EmployeeAccountButtonTabRequest);

        employeeAccountButton.setOnClickListener(v -> {
            Intent intent = new Intent(EmployeeTabRequestActivity.this, EmployeeTabAccountActivity.class);
            startActivity(intent);
        });

        Button employeeFindButton = findViewById(R.id.EmployeeFindButtonTabRequest);

        employeeFindButton.setOnClickListener(v -> {
            Intent intent = new Intent(EmployeeTabRequestActivity.this, EmployeeTabFindActivity.class);
            startActivity(intent);
        });
    }
}
