package combinatorpatterns;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorpatterns.CustomerRejistrationValidator.ValidationResult.SUCCESS;

public interface CustomerRejistrationValidator extends
        Function<Customer, CustomerRejistrationValidator.ValidationResult> {

    static CustomerRejistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ?
                SUCCESS :
                ValidationResult.EMAIL_NOT_VALID;
    }

    static CustomerRejistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+0") ?
                SUCCESS :
                ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRejistrationValidator isAdult() {
        return customer ->
                Period.between(customer.getDob(), LocalDate.now()).getYears()>16 ?
                SUCCESS :
                ValidationResult.IS_NOT_AN_ADULT;
    }
    default CustomerRejistrationValidator and (CustomerRejistrationValidator other){
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }

}
