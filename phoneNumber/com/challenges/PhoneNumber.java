package com.challenges;

class PhoneNumber {
    private String mUnformattedNumber;
    private String mCleanNumber;

    PhoneNumber(String stringOfDigits) {
        mUnformattedNumber = stringOfDigits;
        mCleanNumber = removeNonDigits();
    }

    @Override
    public String toString() {
        return "(" + areaCode() + ") " +
                number().substring(3, 6) + "-" +
                number().substring(6, 10);
    }

    String areaCode() {
        return number().substring(0, 3);
    }

    String number() {
        String number;
        if (invalid_number()) {
            number = "0000000000";
        } else {
            number = getTenDigits();
        }
        return number;
    }

    private String removeNonDigits() {
        String digitsOnlyNumber = new String();
        char[] unformattedNumberArray = mUnformattedNumber.toCharArray();
        for (char character : unformattedNumberArray) {
            try {
                String characterAsString = Character.toString(character);
                Integer.parseInt(characterAsString);
                digitsOnlyNumber = digitsOnlyNumber + characterAsString;
            } catch (NumberFormatException nfe){}
        }
        return digitsOnlyNumber;
    }

    private Boolean invalid_number() {
        return mCleanNumber.length() < 10 ||
                mCleanNumber.length() == 10 && mUnformattedNumber.matches(".+[A-Za-z].+") ||
                mCleanNumber.length() == 11 && !mCleanNumber.startsWith("1") ||
                mCleanNumber.length() > 11;
    }

    private String getTenDigits() {
        String tenDigitNumber;
        if (mCleanNumber.length() == 11) {
            int endIndex = mCleanNumber.length();
            tenDigitNumber = mCleanNumber.substring(1, endIndex);
        } else {
            tenDigitNumber =  mCleanNumber;
        }
        return tenDigitNumber;
    }
}

