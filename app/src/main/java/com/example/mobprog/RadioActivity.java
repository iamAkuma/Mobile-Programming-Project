package com.example.mobprog;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RadioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_activity);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        // Set a checked change listener for the radio group
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Check which radio button was clicked
                RadioButton radioButton = findViewById(checkedId);
                String text = radioButton.getText().toString();

                // Show a toast message with the selected radio button text
                Toast.makeText(RadioActivity.this, "You love " + text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
