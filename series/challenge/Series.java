// Outputs all possible consecutive series of length n in a given string of digits

package challenge;

import java.util.ArrayList;
import java.util.List;

public class Series {
    private String StringOfNumbers;

    public Series(String numbers) {
        this.StringOfNumbers = numbers;
    }

    public List<Integer[]> getSlices(int sliceLength) {
        List<Integer[]> allSlices = new ArrayList<>();
        try {
            int firstIndex = 0;
            int lastIndex = 0;

            while (lastIndex < this.StringOfNumbers.length()) {
                Integer[] slice = new Integer[sliceLength];
                lastIndex = firstIndex + sliceLength;
                char[] charsSlice = this.StringOfNumbers.substring(firstIndex, lastIndex).toCharArray();
                int index = 0;
                for (char charNumber : charsSlice) {
                    slice[index] = Character.getNumericValue(charNumber);
                    index++;
                }
                allSlices.add(slice);
                firstIndex++;
            }

        } catch (StringIndexOutOfBoundsException sioobe) {
            System.out.println("Slice is too large");
        }
        return allSlices;
    }
}
