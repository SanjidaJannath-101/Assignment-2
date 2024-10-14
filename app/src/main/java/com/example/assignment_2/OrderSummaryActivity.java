package com.example.assignment_2;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class OrderSummaryActivity extends AppCompatActivity {

    TextView textOrderSummary;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        textOrderSummary = findViewById(R.id.textOrderSummary);
        btnBack = findViewById(R.id.btnBack);

        String orderSummary = getIntent().getStringExtra("ORDER_SUMMARY");
        textOrderSummary.setText(orderSummary);
        btnBack.setOnClickListener(v -> finish());
    }
}
