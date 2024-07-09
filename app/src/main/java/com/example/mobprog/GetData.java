package com.example.mobprog;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class GetData extends AppCompatActivity {

    private TextView txtReceivedMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        txtReceivedMessage = findViewById(R.id.textViewReceived);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        if (message != null) {
            txtReceivedMessage.setText(message); // Display received message
        }

        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String modifiedData = txtReceivedMessage.getText().toString(); // Get current text
                Intent resultIntent = new Intent();
                resultIntent.putExtra("returnedData", modifiedData); // Send back modified data
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
