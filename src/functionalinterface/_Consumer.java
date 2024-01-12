package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        //normal java function
        Customer maria = new Customer("Maria", "99999");
        greetCustomer(maria);
        greetCustomerV2(maria,false);


        //consumer functional interface
        greetCustomerConsumer.accept(maria);

        //BiConsumer functional interface
        greetCustomerConsumerV2.accept(maria, false);


        //end main
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for rejistering phone number " +
                    (showPhoneNumber ? customer.customerPhoneNumber : "********"));
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for rejistering phone number " +
                    customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for rejistering phone number " +
                customer.customerPhoneNumber);
    }
    static void greetCustomerV2(Customer customer,boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for rejistering phone number " +
                (showPhoneNumber ? customer.customerPhoneNumber : "********"));
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
    //end _Consumer class
}
