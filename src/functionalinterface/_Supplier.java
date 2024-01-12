package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {

        System.out.println(geDbConnectionUrl());
        System.out.println(geDbConnectionUrlSupplier.get());
        System.out.println(geDbConnectionUrlSupplierList.get());
        //end main
    }

    static String geDbConnectionUrl() {
        return "jdbc://localhost:5432/users";
    }
    static Supplier<String> geDbConnectionUrlSupplier = () ->
            "jdbc://localhost:5432/users";
    static Supplier<List<String>> geDbConnectionUrlSupplierList = () ->
           List.of("jdbc://localhost:5432/users","jdbc://localhost:5432/customer");


    // end _supplier class
}
