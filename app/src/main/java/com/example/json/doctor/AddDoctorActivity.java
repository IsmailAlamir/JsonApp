package com.example.json.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.json.AppDatabase;
import com.example.json.R;
import com.example.json.doctor.Doctor;

public class AddDoctorActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);

        Button addButton= findViewById(R.id.submit_doctor_info);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name= findViewById(R.id.et_doctor_name);
                String doctorName= name.getText().toString();

                EditText spec= findViewById(R.id.et_spec_doctor);
                String doctorSpec= spec.getText().toString();

                Doctor doctor=new Doctor(doctorName,doctorSpec);
                Long newDoctorId = AppDatabase.getInstance(getApplicationContext()).doctorDao().insertStudent(doctor);


            }
        });

    }
}