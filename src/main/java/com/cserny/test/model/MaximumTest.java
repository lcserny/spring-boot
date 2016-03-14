package com.cserny.test.model;

/**
 * Created by user on 14.03.2016.
 */
public class MaximumTest
{
    private <T extends Comparable<T>> T maximum(T x, T y, T z)
    {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    public String getComparedString()
    {
        return String.format("Max of %d, %d and %d is: %d", 3, 4, 5, maximum(3, 4, 5));
    }
}
