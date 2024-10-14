package com.example.assignment_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    RadioGroup radioGroupSize;
    CheckBox checkCheese, checkPepperoni, checkMushrooms;
    SeekBar seekBarSpice;
    Switch switchSpecialInstructions;
    RatingBar ratingBarMeal;
    TextView textSpiceValue;
    Button btnSubmit;

    int spiceLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupSize = findViewById(R.id.radioGroupSize);
        checkCheese = findViewById(R.id.checkCheese);
        checkPepperoni = findViewById(R.id.checkPepperoni);
        checkMushrooms = findViewById(R.id.checkMushrooms);
        seekBarSpice = findViewById(R.id.seekBarSpice);
        switchSpecialInstructions = findViewById(R.id.switchSpecialInstructions);
        ratingBarMeal = findViewById(R.id.ratingBarMeal);
        textSpiceValue = findViewById(R.id.textSpiceValue);
        btnSubmit = findViewById(R.id.btnSubmit);

        seekBarSpice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                spiceLevel = progress;
                textSpiceValue.setText("Spice Level: " + spiceLevel);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        btnSubmit.setOnClickListener(v -> {
            StringBuilder orderSummary = new StringBuilder();

            int selectedSizeId = radioGroupSize.getCheckedRadioButtonId();
            RadioButton selectedSize = findViewById(selectedSizeId);
            if (selectedSize != null) {
                orderSummary.append("Meal Size: ").append(selectedSize.getText()).append("\n");
            }

            orderSummary.append("Toppings: ");
            if (checkCheese.isChecked()) orderSummary.append("Extra Cheese ");
            if (checkPepperoni.isChecked()) orderSummary.append("Pepperoni ");
            if (checkMushrooms.isChecked()) orderSummary.append("Mushrooms ");
            orderSummary.append("\n");

            orderSummary.append("Spice Level: ").append(spiceLevel).append("\n");

            if (switchSpecialInstructions.isChecked()) {
                orderSummary.append("Special Instructions: Yes\n");
            } else {
                orderSummary.append("Special Instructions: No\n");
            }

            float rating = ratingBarMeal.getRating();
            orderSummary.append("Rating: ").append(rating).append(" stars\n");

            Intent intent = new Intent(MainActivity.this, OrderSummaryActivity.class);
            intent.putExtra("ORDER_SUMMARY", orderSummary.toString());
            startActivity(intent);
        });
    }
}
