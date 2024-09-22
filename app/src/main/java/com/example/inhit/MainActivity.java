package com.example.inhit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputCelsius;
    private EditText inputFahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputCelsius = findViewById(R.id.ed_c);
        inputFahrenheit = findViewById(R.id.ed_f);
        Button cToFButton = findViewById(R.id.bt_CC);
        Button fToCButton = findViewById(R.id.bt_CF);
        Button clearButton = findViewById(R.id.bt_Clear);

        // Logic cho nút chuyển đổi từ F sang C
        cToFButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFToC();
            }
        });

        // Logic cho nút chuyển đổi từ C sang F
        fToCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCToF();
            }
        });

        // Logic cho nút Clear
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputCelsius.setText("");
                inputFahrenheit.setText("");
            }
        });
    }

    private void convertCToF() {
        String celsiusInput = inputCelsius.getText().toString();
        if (!celsiusInput.isEmpty()) {
            double celsius = Double.parseDouble(celsiusInput);
            double fahrenheit = (celsius * 9 / 5) + 32;
            inputFahrenheit.setText(String.format("%.2f", fahrenheit));
        }
    }

    private void convertFToC() {
        String fahrenheitInput = inputFahrenheit.getText().toString();
        if (!fahrenheitInput.isEmpty()) {
            double fahrenheit = Double.parseDouble(fahrenheitInput);
            double celsius = (fahrenheit - 32) * 5 / 9;
            inputCelsius.setText(String.format("%.2f", celsius));
        }
    }
}
