package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etWeight, etHeight;
    private Button btnCalculate;
    private TextView tvResult;
    private Spinner spinnerWeightUnit, spinnerHeightUnit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //hook
        etWeight = findViewById(R.id.et_weight);
        etHeight = findViewById(R.id.et_height);
        spinnerWeightUnit = findViewById(R.id.spinner_weight_unit);
        spinnerHeightUnit = findViewById(R.id.spinner_height_unit);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        //Instance for spinner
            //weight
        ArrayAdapter<CharSequence>weightAdapter = ArrayAdapter.createFromResource(this,R.array.weight_units, android.R.layout.simple_spinner_dropdown_item);
        weightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWeightUnit.setAdapter(weightAdapter);

            //height
        ArrayAdapter<CharSequence>heightAdapter = ArrayAdapter.createFromResource(this, R.array.height_units, android.R.layout.simple_spinner_dropdown_item);
        heightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHeightUnit.setAdapter(heightAdapter);

        //btn listener
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
                Toast.makeText(MainActivity.this, "Developed By: Jayvee Somido", Toast.LENGTH_SHORT).show();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void calculateBMI(){
        String weightStr = etWeight.getText().toString();
        String heightStr = etHeight.getText().toString();

        if(!weightStr.isEmpty() && !heightStr.isEmpty()){
            try {
                double weight = Double.parseDouble(weightStr);
                double height = Double.parseDouble(heightStr);

                String selectedWeightUnit = spinnerWeightUnit.getSelectedItem().toString();
                String selectedHeightUnit = spinnerHeightUnit.getSelectedItem().toString();

                if (selectedWeightUnit.equals("Pounds")){
                    weight = weight * 0.453592;
                }

                switch (selectedHeightUnit){
                    case "Feet":
                        height = height * 0.3048;
                        break;
                    case "Inches":
                        height = height * 0.0254;
                        break;
                    case "Centimeters":
                        height = height / 100;
                        break;
                    default:
                        //No conversion needed for the Meters
                }

                //Calculate BMI
                double heightsquared = height * height;
                double bmi = weight / heightsquared;

                //BMI Category
                String category;
                if (bmi < 18.5) {
                    category = "Underweight";
                } else if (bmi >= 18.5 && bmi <= 24.9) {
                    category = "Normal";
                } else if (bmi >= 25 && bmi <= 29.9) {
                    category = "Overweight";
                } else {
                    category = "Obese";
                }

                //Display BMI
                tvResult.setTextColor(this.getResources().getColor(R.color.black));
                tvResult.setText(String.format("BMI: %.2f\nCategory: %s",bmi,category));

            }catch(NumberFormatException e){
                tvResult.setTextColor(this.getResources().getColor(R.color.red));
                tvResult.setText("Invalid input. Please enter valid numbers.");
            }
        }else{
            tvResult.setTextColor(this.getResources().getColor(R.color.red));
            tvResult.setText("Please Enter both Weight and Height");
        }



    }


}