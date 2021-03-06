package challenge;

import org.junit.Test;
import static org.junit.Assert.*;

public class PhoneNumberTest {

    @Test
    public void shouldReturnACleanNumber() throws Exception {
        PhoneNumber phoneNumber = new PhoneNumber("(123) 456-7890");

        String cleanNumber = phoneNumber.number();

        assertEquals("Number", "1234567890", cleanNumber);
    }

    @org.testng.annotations.Test
    public void shouldCleanNumberWithDots() throws Exception {
        PhoneNumber phoneNumber = new PhoneNumber("456.123.7890");

        String cleanNumber = phoneNumber.number();

        assertEquals("4561237890", cleanNumber);
    }

    @Test
    public void shouldReturnZerosNumberForInputWithLetters() throws Exception {
        PhoneNumber phoneNumber = new PhoneNumber("123-abc-1234");

        String zerosNumber = phoneNumber.number();

        assertEquals("0000000000", zerosNumber);
    }

    @Test
    public void shouldReturnZerosNumberForInputOfNineDigits() throws Exception {
        PhoneNumber phoneNumber = new PhoneNumber("123456789");

        String zerosNumber = phoneNumber.number();

        assertEquals("0000000000", zerosNumber);
    }

    @org.junit.Test
    public void shouldReturnCleanNumberForInputOfElevenDigitsStartingWithOne() throws Exception {
        PhoneNumber phoneNumber = new PhoneNumber("19876543210");

        String cleanNumber = phoneNumber.number();

        assertEquals("9876543210", cleanNumber);
    }

    @Test
    public void shouldReturnCleanNumberForInputOfTenDigitStartingWithOne() throws Exception {
        PhoneNumber phoneNumber   = new PhoneNumber("1234567890");

        String cleanNumber = phoneNumber.number();

        assertEquals("1234567890", cleanNumber);
    }

    @Test
    public void shouldReturnZerosNumberForInputOfElevenDigitsNotStartingWithOne() throws Exception {
        PhoneNumber phoneNumber = new PhoneNumber("21234567890");

        String zerosNumber = phoneNumber.number();

        assertEquals("0000000000", zerosNumber);
    }

    @Test
    public void shouldReturnZerosNumberForInputOfTwelveDigitsStartingWithOne() throws Exception {
        PhoneNumber phonenumber = new PhoneNumber("112345678901");

        String zerosNumber = phonenumber.number();

        assertEquals("0000000000", zerosNumber);
    }

    @Test
    public void shouldReturnZerosNumberForInputOfTenDigitsAndLetters() throws Exception {
        PhoneNumber phoneNumber = new PhoneNumber("1a2a3a4a5a6a7a8a9a0a");

        String zerosNumber = phoneNumber.number();

        assertEquals("0000000000", zerosNumber);
    }

    @Test
    public void shouldReturnAreaCode() throws Exception {
        PhoneNumber phoneNumber = new PhoneNumber("1234567890");

        String areaCode = phoneNumber.areaCode();

        assertEquals("123", areaCode);
    }

    @Test
    public void shouldReturnFormattedNumber() throws Exception {
        PhoneNumber phoneNumber = new PhoneNumber("5551234567");

        String formattedNumber = phoneNumber.toString();

        assertEquals("(555) 123-4567", formattedNumber);
    }

    @Test
    public void shouldReturnFormattedNumberForInputStartingWithOne() throws Exception {
        PhoneNumber phoneNumber = new PhoneNumber("11234567890");

        String formattedNumber = phoneNumber.toString();

        assertEquals("(123) 456-7890", formattedNumber);
    }
}