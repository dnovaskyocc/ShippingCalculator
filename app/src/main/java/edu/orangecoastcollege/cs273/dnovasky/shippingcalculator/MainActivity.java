package edu.orangecoastcollege.cs273.dnovasky.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView mBaseCost;
    private TextView mAddedCost;
    private TextView mTotalCost;
    private EditText mWeightField;

    private ShipItem mItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBaseCost = (TextView) findViewById(R.id.baseCurrencyTextView);
        mAddedCost = (TextView) findViewById(R.id.addedCurrencyTextView);
        mTotalCost = (TextView) findViewById(R.id.totalCurrencyTextView);

        mItem = new ShipItem();
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                NumberFormat format = NumberFormat.getCurrencyInstance();
                if(isEmpty(mWeightField))
                {
                    mBaseCost.setText(R.string.zero_dollars);
                    mAddedCost.setText(R.string.zero_dollars);
                    mTotalCost.setText(R.string.zero_dollars);
                }
                else
                {
                    mItem.setWeight(Integer.parseInt(charSequence.toString()));
                    mBaseCost.setText(format.format(mItem.getBaseCost()));
                    mAddedCost.setText(format.format(mItem.getAddedCost()));
                    mTotalCost.setText(format.format(mItem.getTotalCost()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        mWeightField = (EditText) findViewById(R.id.packageWeightEditText);

        assert mWeightField != null;
        mWeightField.addTextChangedListener(textWatcher);
    }
    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }
}
