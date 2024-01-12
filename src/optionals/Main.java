package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable("Hello")
                .orElseGet(() -> "default value");
        System.out.println(value);
        System.out.println("-------------------");
        Optional.ofNullable("john@gmail.com")
                .ifPresent(email -> System.out.println("Sending email to " + email));
        System.out.println("-------------------");
        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> {
                            System.out.println("cannot send email");
                        }
                );
        //end main
    }
}
