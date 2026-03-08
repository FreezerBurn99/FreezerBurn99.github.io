package com.example.ttrpgtravelcalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*
 MainActivity handles the UI layer of the application.

 It collects user inputs such as:
 - Speed (feet/meters per round)
 - Distance
 - Maximum travel time per day
 - Desired output unit

 It sends those values to the TravelCalculator class
 and displays the returned result.
*/

public class MainActivity extends AppCompatActivity {

    private EditText speedInput;
    private EditText distanceInput;
    private EditText maxHoursInput;

    private Spinner outputUnitSpinner;
    private Spinner distanceUnitSpinner;

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speedInput = findViewById(R.id.speedInput);
        distanceInput = findViewById(R.id.distanceInput);
        maxHoursInput = findViewById(R.id.maxHoursInput);

        outputUnitSpinner = findViewById(R.id.outputUnitSpinner);
        distanceUnitSpinner = findViewById(R.id.distanceUnitSpinner);

        Button calculateButton = findViewById(R.id.calculateButton);

        resultText = findViewById(R.id.resultText);

        /*
         When the user presses the Calculate button,
         gather inputs and call the TravelCalculator module.
        */

        calculateButton.setOnClickListener(v -> {

            double speed = Double.parseDouble(speedInput.getText().toString());
            double distance = Double.parseDouble(distanceInput.getText().toString());
            double maxHours = Double.parseDouble(maxHoursInput.getText().toString());

            TimeUnit unit = TimeUnit.valueOf(
                    outputUnitSpinner.getSelectedItem().toString()
            );
            DistanceUnit distanceUnit = DistanceUnit.valueOf(
                distanceUnitSpinner.getSelectedItem().toString();
            )

            double result = TravelCalculator.calculateTravelTime(
                    speed,
                    distance,
                    maxHours,
                    unit
            );

            resultText.setText("Travel Time: " + result + " " + unit.name());
        });
    }
}
