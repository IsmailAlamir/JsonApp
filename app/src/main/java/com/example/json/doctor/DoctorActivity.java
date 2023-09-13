package com.example.json.doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.json.AppDatabase;
import com.example.json.R;

import java.util.ArrayList;

public class DoctorActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);


//        ArrayList<Doctor> doctorList = new ArrayList<Doctor>();

        ArrayList<Doctor> doctorList = (ArrayList<Doctor>) AppDatabase.getInstance(getApplicationContext()).doctorDao().getAll();


        doctorList.add(new Doctor("Mohammad","Surgeon"));
        doctorList.add(new Doctor("Rami","Psychiatrist"));
        doctorList.add(new Doctor("Ihab","Oncologist"));


      RecyclerView rv = findViewById(R.id.rv_doctors);


        // set a layout manager
        rv.setLayoutManager(new LinearLayoutManager(this));

        // set the adapter for this recycler view
        // DoctorAdapter doctorAdapter = new DoctorAdapter(doctorList);
        // rv.setAdapter(doctorAdapter);
        rv.setAdapter(new DoctorAdapter(doctorList));


        Button addBtn = findViewById(R.id.btn_add_doctor);
        addBtn.setOnClickListener((v)->{
            Intent intent = new Intent(this, AddDoctorActivity.class);
            startActivity(intent);

        });
    }
}
