// Cleans up given phone number and outputs the following format: (123) 456-7890

package com.challenges;

public class Main {

    public static void main(String[] args) {
        PhoneNumber phoneNumber1 = new PhoneNumber("5551234567");
        PhoneNumber phoneNumber2 = new PhoneNumber("11234567890");
        PhoneNumber phoneNumber3 = new PhoneNumber("123-abc-1234");
        System.out.println(phoneNumber1);
        System.out.println(phoneNumber2);
        System.out.println(phoneNumber3.number());
    }
}
