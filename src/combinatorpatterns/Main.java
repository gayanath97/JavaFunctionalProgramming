package combinatorpatterns;

import java.time.LocalDate;

import static combinatorpatterns.CustomerRejistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alica",
                "alica@gmail.com",
                "+08555444",
                LocalDate.of(2000,1,1)
        );
       // System.out.println(new CustomerValidationService().isValid(customer));

        //using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isEmailValid())
                .and(isAdult())
                .apply(customer);
        System.out.println(result);

        if(result!=ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
