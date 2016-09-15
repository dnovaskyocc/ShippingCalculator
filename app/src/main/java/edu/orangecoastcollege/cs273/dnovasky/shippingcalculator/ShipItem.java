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

    /**
     * Creates a package to be shipped and sets the base cost to $3.00
     * all other fields are defaulted to 0.
     */
    public ShipItem()
    {
        mBaseCost = 3.0;
        mWeight = 0;
        mAddedCost = 0;
        mTotalCost = 0;
    }

    /**
     * Gets the base cost of the package
     * @return mBaseCost this returns the base cost of the package
     */
    public double getBaseCost() {
        return mBaseCost;
    }

    /**
     * Gets the added cost of the package
     * @return mAddedCost this returns the cost of the package
     */
    public double getAddedCost() {
        return mAddedCost;
    }

    /**
     * Gets the total cost of the package
     * @return mTotalCost this return the total cost of the packge
     */
    public double getTotalCost() {
        return mTotalCost;
    }

    /**
     * Changes the weight of the package. And adjust the base and
     * cost accordingly.
     * @param weight the packages new weight
     */
    public void setWeight(int weight) {

        mWeight = weight;
        mAddedCost = 0;

        if(mWeight == 0)
            mBaseCost = 0;
        else
        {
            mBaseCost = 3.0;
            if(mWeight > 16)
                mAddedCost = Math.ceil((weight - 16) / 4.0) * .5;
        }
        mTotalCost = mBaseCost + mAddedCost;
    }
}
