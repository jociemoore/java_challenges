// Cleans up given phone number and outputs the following format: (123) 456-7890

package challenge;

public class PhoneNumber {
    private String cleanNumber;

    public PhoneNumber(String stringOfDigits) {
        this.cleanNumber = removeNonDigits(stringOfDigits);
        if (invalidNumber(stringOfDigits)) this.cleanNumber = "0000000000";
    }

    @Override
    public String toString() {
        return String.format("(%s) %s-%s", areaCode(), number().substring(3, 6), number().substring(6, 10));
    }

    String areaCode() {
        return number().substring(0, 3);
    }

    String number() {
        return getTenDigits();
    }

    private String removeNonDigits(String unformattedDigits) {
        String digitsOnlyNumber = "";
        char[] unformattedNumberArray = unformattedDigits.toCharArray();
        for (char character : unformattedNumberArray) {
            try {
                String characterAsString = Character.toString(character);
                Integer.parseInt(characterAsString);
                digitsOnlyNumber = digitsOnlyNumber + characterAsString;
            } catch (NumberFormatException nfe) {
                // Skip over all characters that are not numbers.
            }
        }
        return digitsOnlyNumber;
    }

    private Boolean invalidNumber(String unformattedDigits) {
        return this.cleanNumber.length() < 10 ||
                this.cleanNumber.length() == 10 && unformattedDigits.matches(".*[A-Za-z].*") ||
                this.cleanNumber.length() == 11 && !this.cleanNumber.startsWith("1") ||
                this.cleanNumber.length() > 11;
    }

    private String getTenDigits() {
        String tenDigitNumber;
        if (this.cleanNumber.length() == 11) {
            int endIndex = this.cleanNumber.length();
            tenDigitNumber = this.cleanNumber.substring(1, endIndex);
        } else {
            tenDigitNumber =  this.cleanNumber;
        }
        return tenDigitNumber;
    }
}

