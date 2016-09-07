package edu.orangecoastcollege.cs273.dnovasky.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final double BASE_COST = 3.00;

    private TextView mBaseCost;
    private TextView mAddedCost;
    private TextView mTotalCost;
    private EditText mWeightField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBaseCost = (TextView) findViewById(R.id.baseCurrencyTextView);
        mAddedCost = (TextView) findViewById(R.id.addedCurrencyTextView);
        mTotalCost = (TextView) findViewById(R.id.totalCurrencyTextView);

        mWeightField = (EditText) findViewById(R.id.packageWeightEditText);

    }
}
