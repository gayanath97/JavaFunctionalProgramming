package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {

        System.out.println("without predicate");
        System.out.println(isPhoneNumberValid("0770003000"));
        System.out.println(isPhoneNumberValid("0900000"));

        System.out.println("with Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("0770000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0900000"));

        System.out.println(
                "Is phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate.and(containNumber3).test("0770003000"));
        System.out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.or(containNumber3).test("0770000000"));

        //end of main
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("077") && phoneNumber.length() == 10;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("077") && phoneNumber.length() == 10;

    static Predicate<String> containNumber3 = phoneNumber ->
            phoneNumber.contains("3");

//end _Predicate class
}
