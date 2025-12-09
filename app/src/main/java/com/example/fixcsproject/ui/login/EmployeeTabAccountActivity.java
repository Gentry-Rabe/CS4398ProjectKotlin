package com.example.fixcsproject.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fixcsproject.R;
import com.example.fixcsproject.laundryapp.model.UserAccount;

public class EmployeeTabAccountActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employeetabaccount);

        //fill in info on profile
        TextView profileDesc = findViewById(R.id.employeeAccountPageProfileDesc);

        UserAccount sessionUser = UserDatabase.getInstance().getSessionUser();

        if (profileDesc != null && sessionUser != null) {
            String profileText = "Signed in as: " + sessionUser.getName() +
                                 "\nRating: " + sessionUser.getRating();
            profileDesc.setText(profileText);
        } else if (profileDesc != null) {
            profileDesc.setText("Error: User not logged in or profile view not found.");
        }

        Button employeeRequestButton = findViewById(R.id.EmployeeRequestButtonTabAccount);

        employeeRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeTabAccountActivity.this, EmployeeTabRequestActivity.class);
                startActivity(intent);
            }
        });

        Button employeeFindButton = findViewById(R.id.EmployeeFindButtonTabAccount);

        employeeFindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeTabAccountActivity.this, EmployeeTabFindActivity.class);
                startActivity(intent);
            }
        });

        Button employeeEditButton = findViewById(R.id.button5);

        employeeEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeTabAccountActivity.this, EmployeeAccountEditActivity.class);
                startActivity(intent);
            }
        });

    }
}
