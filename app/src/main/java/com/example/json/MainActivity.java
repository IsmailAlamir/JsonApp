package com.example.json;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    static final String TAG= MainActivity.class.getName();
    public static final int COPYRIGHT_ID = R.id.copyright;
    public static final int SETTING_ID = R.id.settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int itemId = item.getItemId();
//
//        switch (itemId) {
//            case 2131296758:
//                navigateToSettings();
//                return true;
//            case 2131296757:
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


}