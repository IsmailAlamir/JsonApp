package com.example.json;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;
import java.util.prefs.Preferences;

public class SettingActivity extends AppCompatActivity {
    EditText mNameEditText;
    public static final String NAME = "name";
    static final String TAG= SettingActivity.class.getName();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        mNameEditText =findViewById(R.id.et_name);
        Button btnSubmit = findViewById(R.id.button_submit_name);



        btnSubmit.setOnClickListener(view -> {
                Log.i(TAG, "Submit button clicked");
                if (mNameEditText.getText().toString().length() >= 10) {
                    saveName();
                } else {

                    Toast.makeText(SettingActivity.this, "Name Saved", Toast.LENGTH_SHORT).show();
                    //Explanation: You are creating an anonymous inner class when you use this part of your code:
                    //new OnClickListener() so you need to change "" this "" to "" SettingActivity.this ""

                }

                // Check if no view has focus
                // to hide the keyboard after click the btn
                View view2 = SettingActivity.this.getCurrentFocus();
                if (view2 != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view2.getWindowToken(), 0);
                }





        });


        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!btnSubmit.isEnabled()) {
                    btnSubmit.setEnabled(true);
                }

                if (s.toString().length() == 0){
                    btnSubmit.setEnabled(false);
                }


            }
        });
    }


//    private void saveAddress() {
//        // get the text from the edit text
//        String name = mNameEditText.getText().toString();
//
//        // create shared preference object and set up an editor
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor preferenceEditor = sharedPreferences.edit();
//
//        // save the text to shared preferences
//        preferenceEditor.putString(NAME, name);
//        preferenceEditor.apply();
//
//        Toast.makeText(this, "Name Saved", Toast.LENGTH_SHORT).show();
//    }


    private void saveName(){
        // get the text from the edit text
        String name = mNameEditText.getText().toString();

        // create shared preference object and set up an editor
//        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();


        // save the text to shared preferences

//        editor.putString("name", name);
//        editor.apply();
//
//        Log.i(TAG, name);
//        Toast.makeText(this, "Name Saved", Toast.LENGTH_SHORT).show();
//


        SharedPreferences sharedPref = getSharedPreferences("MyData",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(NAME,name);
        editor.commit();


    }





}

