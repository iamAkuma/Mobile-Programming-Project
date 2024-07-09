package com.example.mobprog;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AssignmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment);

        Spinner spin = findViewById(R.id.spinner);
        String[] courses = {"BCA", "BIM", "BIT", "BScCSIT", "BE"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        addListenerOnButton();
    }

    public void addListenerOnButton() {
        EditText nam = findViewById(R.id.username);
        EditText Add = findViewById(R.id.userAddress);
        Button buttonShow = findViewById(R.id.button);
        TextView output1 = findViewById(R.id.output1);
        TextView output2 = findViewById(R.id.output2);
        RadioButton checkMale = findViewById(R.id.radio_male); // Updated
        RadioButton checkFemale = findViewById(R.id.radio_female); // Updated
        CheckBox checkBoxAgreement = findViewById(R.id.checkBoxAgreement); // Updated

        // Set up button click listener
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nam.getText().toString().trim();
                String address = Add.getText().toString().trim();
                String gender = "";
                String paisa = "";

                Spinner spin = findViewById(R.id.spinner);
                String selectedCourse = spin.getSelectedItem().toString();

                // Determine gender based on CheckBox state
                if (checkMale.isChecked()) {
                    gender = "Male";
                } else if (checkFemale.isChecked()) {
                    gender = "Female";
                }

                // Determine user agreement based on CheckBox state
                if (checkBoxAgreement.isChecked()) {
                    paisa = "User agreed.";
                } else {
                    paisa = "User did not agree.";
                }

                // Display the entered text in TextViews
                output1.setText("Name: " + name);
                output2.setText("Address: " + address +
                        "\nGender: " + gender +
                        "\nAgreement: " + paisa +
                        "\nCourse: " + selectedCourse);
            }
        });
    }
}
