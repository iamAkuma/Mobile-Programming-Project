package com.example.mobprog;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox checkBoxReact;
    private CheckBox checkBoxNext;
    private CheckBox checkBoxVue;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box); // Assuming your XML file is named activity_main.xml

        // Find CheckBox and TextView views from XML layout
        checkBoxReact = findViewById(R.id.checkBox);
        checkBoxNext = findViewById(R.id.checkBox1);
        checkBoxVue = findViewById(R.id.checkBox2);
        textViewResult = findViewById(R.id.result);

        // Set listener for CheckBox events
        checkBoxReact.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateResultText();
            }
        });

        checkBoxNext.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateResultText();
            }
        });

        checkBoxVue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateResultText();
            }
        });
    }

    private void updateResultText() {
        StringBuilder result = new StringBuilder();

        if (checkBoxReact.isChecked()) {
            result.append("REACTJS ");
        }
        if (checkBoxNext.isChecked()) {
            result.append("NEXTJS ");
        }
        if (checkBoxVue.isChecked()) {
            result.append("VueJS ");
        }

        textViewResult.setText(result.toString().trim());
    }
}
