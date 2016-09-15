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

        // Initialize our member variables
        mBaseCost = (TextView) findViewById(R.id.baseCurrencyTextView);
        mAddedCost = (TextView) findViewById(R.id.addedCurrencyTextView);
        mTotalCost = (TextView) findViewById(R.id.totalCurrencyTextView);

        // Initialize our item to be sipped
        mItem = new ShipItem();

        // Create our TextWatcher to listen for changes in the package weight
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                // Create a NumberFormat object to set the currency to the current locale
                NumberFormat format = NumberFormat.getCurrencyInstance();

                // Check if the mWeightTeField is empty.
                if(isEmpty(mWeightField))
                {
                    // It's empty so we display $0.00 for all cost
                    mBaseCost.setText(R.string.zero_dollars);
                    mAddedCost.setText(R.string.zero_dollars);
                    mTotalCost.setText(R.string.zero_dollars);
                }
                else
                {
                    // It's not empty so we update display accordingly
                    mItem.setWeight(Integer.parseInt(charSequence.toString()));
                    mBaseCost.setText(format.format(mItem.getBaseCost()));
                    mAddedCost.setText(format.format(mItem.getAddedCost()));
                    mTotalCost.setText(format.format(mItem.getTotalCost()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Do nothing
            }
        };

        // Connect our edit text member variable to our edit text in the UI
        mWeightField = (EditText) findViewById(R.id.packageWeightEditText);

        // Assert that our EditText field has been initialized
        assert mWeightField != null;
        // Add our text watcher to listen for changes
        mWeightField.addTextChangedListener(textWatcher);
    }

    /**
     * Check to see if our EditText field is empty
     * @param etText the Edit Text field we ant to check
     * @return true if its empty false otherwise
     */
    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }
}
