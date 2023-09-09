package com.example.json;

import static com.example.json.SettingActivity.NAME;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    static final String TAG= MainActivity.class.getName();
    TextView nameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView =findViewById(R.id.tv_main_name);
        Button submitBtn= findViewById(R.id.button_submit);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"submit button clicked!");
                navigateToBloodDetails();
            }
        });




    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: called : we can see the screen");
        Log.i(TAG, nameTextView.getText().toString()+"");
        setName();
        Log.i(TAG, nameTextView.getText().toString()+"");


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int itemId = item.getItemId();
//
//        switch (itemId) {
//            case R.id.settings:
//                navigateToSettings();
//                return true;
//            case R.id.copyright:
//                Toast.makeText(this, "Copy right 2023", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.settings) {
            navigateToSettings();
            return true;
        } else if (itemId == R.id.copyright) {
            Toast.makeText(this, "Copy right 2023", Toast.LENGTH_LONG).show();
            Log.i(TAG,"Copy Right 2023");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    private void navigateToBloodDetails() {
        Intent bloodIntent= new Intent(this, BloodActivity.class);
        startActivity(bloodIntent);
    }
    private void navigateToSettings() {
        Intent settingsIntent = new Intent(this, SettingActivity.class);
        startActivity(settingsIntent);
    }


    private void setName() {
        // get text out of shared preference
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
        String name = sharedPreferences.getString("name","No Name Yet");

        // set text on text view
        nameTextView.setText(name);


    }


}