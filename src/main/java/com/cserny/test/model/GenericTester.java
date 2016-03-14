package com.cserny.test.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 14.03.2016.
 */
public class GenericTester
{
    private  <E> String printArray(E[] inputArray)
    {
        StringBuilder builder = new StringBuilder();
        for (E element : inputArray) {
            builder.append(element).append(", ");
        }
        return builder.append("<br>").toString();
    }

    public List<String> getGenericStrings()
    {
        Integer[] intArray = {1, 2, 3, 4, 5, 6};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
        Character[] charArray = {'A', 'B', 'C', 'D', 'E', 'F'};

        List<String> strings = new ArrayList<String>();
        strings.add(printArray(intArray));
        strings.add(printArray(doubleArray));
        strings.add(printArray(charArray));

        return strings;
    }
}
