package edu.orangecoastcollege.cs273.dnovasky.shippingcalculator;

/**
 * Created by dnova_000 on 9/8/2016.
 * This class represents and item to be shipped. The baseCost will always
 * be 3 dollars assuming the weight is greater than 0.
 * @author Donald E. Novasky
 */
public class ShipItem {

    private int mWeight;
    private double mBaseCost;
    private double mAddedCost;
    private double mTotalCost;

    public ShipItem()
    {
        mBaseCost = 3.0;
    }

    public double getBaseCost() {
        return mBaseCost;
    }

    public double getAddedCost() {
        return mAddedCost;
    }

    public double getTotalCost() {
        return mTotalCost;
    }

    public void setWeight(int weight) {

        mWeight = weight;
        mAddedCost = 0;

        if(mWeight == 0)
        {
            mBaseCost = 0;
        }
        else
        {
            mBaseCost = 3.0;
            if(mWeight > 16)
                mAddedCost = Math.ceil((weight - 16) / 4.0) * .5;
        }
        mTotalCost = mBaseCost + mAddedCost;
    }
}
