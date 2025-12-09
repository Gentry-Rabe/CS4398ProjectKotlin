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
import com.google.android.gms.maps.MapView;

public class UserTabRequestActivity extends Activity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usertabrequest);

        mapView = findViewById(R.id.mapView2);
        mapView.onCreate(savedInstanceState);

        Button accountButton = findViewById(R.id.AccountButton);

        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserTabRequestActivity.this, UserTabAccountActivity.class);
                startActivity(intent);
            }
        });

        Button submitRequest = findViewById(R.id.submitJobUser);

        submitRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText jobType = findViewById(R.id.JobTypeUser);
                EditText jobAddress = findViewById(R.id.jobAddressUser);
                EditText jobDescription = findViewById(R.id.JobDescUser);
                TextView requestError = findViewById(R.id.requestError);
                EditText price = findViewById(R.id.JobPriceUser);
                EditText optionalRequest = findViewById(R.id.OptReqUser);



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

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
