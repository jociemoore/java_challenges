package com.challenges;

import java.util.ArrayList;
import java.util.List;

public class Series {
    private String mStringOfNumbers;

    public Series(String numbers) {
        mStringOfNumbers = numbers;
    }

    public List<Integer[]> getSlices(int sliceLength) {
        List<Integer[]> allSlices = new ArrayList<>();
        int firstIndex = 0;
        int lastIndex = 0;

        while (lastIndex < mStringOfNumbers.length()) {
            Integer[] slice = new Integer[sliceLength];
            lastIndex = firstIndex + sliceLength;
            char[] charsSlice = mStringOfNumbers.substring(firstIndex, lastIndex)
                                                .toCharArray();
            int index = 0;
            for (char charNumber : charsSlice) {
                slice[index] = Character.getNumericValue(charNumber);
                index++;
            }
            allSlices.add(slice);
            firstIndex++;
        }
        return allSlices;
    }

}
