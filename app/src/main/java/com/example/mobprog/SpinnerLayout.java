package com.example.mobprog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SpinnerLayout extends AppCompatActivity {

    private TextView selectedTextView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_layout);

        spinner = findViewById(R.id.spinner);
        selectedTextView = findViewById(R.id.selected_item_textview);
        Button showSelectedButton = findViewById(R.id.show_selected_button);

        // Create an ArrayAdapter using the string array with prompt and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.countries,
                android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Set a prompt to be displayed in the spinner
        spinner.setPrompt(getString(R.string.select_the_country_where_you_want_to_go));

        // Set a listener to handle the selection of spinner item
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    // Handle the prompt selection
                    selectedTextView.setText("No item selected");
                } else {
                    // Retrieve the selected item
                    String selectedItem = parent.getItemAtPosition(position).toString();
                    // Update the TextView with the selected item
                    selectedTextView.setText("Selected Item: " + selectedItem);
                }
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle the case where no item has been selected
                selectedTextView.setText("No item selected");
            }
        });

        // Set click listener for the button
        showSelectedButton.setOnClickListener(v -> {
            // Get the currently selected item from the spinner
            int position = spinner.getSelectedItemPosition();
            if (position == 0) {
                // If "Select One" is selected, show a toast message
                Toast.makeText(SpinnerLayout.this, "Please select a country", Toast.LENGTH_SHORT).show();
            } else {
                // Retrieve the selected item
                String selectedItem = spinner.getSelectedItem().toString();
                // Show the selected item in a toast message
                Toast.makeText(SpinnerLayout.this, "Selected Item: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to handle button click (can be used in XML layout)
    public void onShowSelectedClick(View view) {
        // Get the currently selected item from the spinner
        int position = spinner.getSelectedItemPosition();
        if (position == 0) {
            // If "Select One" is selected, show a toast message
            Toast.makeText(this, "Please select a country", Toast.LENGTH_SHORT).show();
        } else {
            // Retrieve the selected item
            String selectedItem = spinner.getSelectedItem().toString();
            // Show the selected item in a toast message
            Toast.makeText(this, "Selected Item: " + selectedItem, Toast.LENGTH_SHORT).show();
        }
    }
}
