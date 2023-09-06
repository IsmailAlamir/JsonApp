package com.example.json;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitBtn= findViewById(R.id.button_submit);

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
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1000001:
                navigateToSettings();
                return true;
            case 1000003:
                Toast.makeText(this, "Copy right 2023", Toast.LENGTH_SHORT).show();
                return true;
            default:
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