package com.example.fixcsproject.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fixcsproject.R;
import com.example.fixcsproject.laundryapp.model.AppData;
import com.example.fixcsproject.laundryapp.model.Job;

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

        Button submitRequest = findViewById(R.id.SubmitJobEmployee);

        submitRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText jobType = findViewById(R.id.JobTypeEmployee);
                EditText jobAddress = findViewById(R.id.jobAddressEmployee);
                EditText jobDescription = findViewById(R.id.JobDescUser);
                TextView requestError = findViewById(R.id.ErrorMsgEmployee);
                EditText price = findViewById(R.id.JobPriceEmployee);
                EditText optionalRequest = findViewById(R.id.OptReqEmployee);



                if (jobType.getText().toString().isEmpty() ||
                        jobAddress.getText().toString().isEmpty() ||
                        jobDescription.getText().toString().isEmpty()) {
                    requestError.setText("Please fill in all required fields.");
                    return;
                } else {
                    requestError.setText(""); // Clear error if previously shown
                    Job job = new Job(AppData.INSTANCE.getJobs().size() + 1, jobDescription.getText().toString(), jobAddress.getText().toString(), Double.parseDouble(price.getText().toString()));
                    AppData.INSTANCE.getJobs().add(job);
                    jobType.setText("");
                    jobAddress.setText("");
                    jobDescription.setText("");
                    price.setText("");
                    optionalRequest.setText("");
                }
            }
        });
    }
}
