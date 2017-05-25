package com.challenges;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Series series = new Series("12345");
        List<Integer[]> slices = series.getSlices(3);
//        System.out.println(slices);
        for (Integer[] slice : slices) {
            System.out.println(Arrays.toString(slice));
        }
    }
}
