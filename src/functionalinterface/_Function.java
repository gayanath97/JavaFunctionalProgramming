package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = increment(1);
        System.out.println(increment);

        int increment2 = incrementOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multipleBy10Function.apply(increment2);
        System.out.println(multiply);

        int afterChaining = addBy1AndThenMultiplyBy10.apply(4);
        System.out.println("After function chaining");
        System.out.println(afterChaining);

        int val = incrementByOneAndMultiply(4,100);
        System.out.println("normal java func");
        System.out.println(val);

       //BiFunction
       int val2 = incrementByOneAndMultiplyBiFunction.apply(4,100);
       System.out.println("biFunction");
       System.out.println(val2);

//end of Main()
    }
    static int increment(int number){
        return number+1;
    }
    static int incrementByOneAndMultiply(int number,int numToMultiplyByNumber){
        return (number+1)*numToMultiplyByNumber;
    }
    //biFunction
    static BiFunction<Integer,Integer,Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    ->(numberToIncrementByOne + 1)*numberToMultiplyBy;
    static Function<Integer,Integer> incrementOneFunction =
            number -> number+1;
    static  Function<Integer,Integer> multipleBy10Function =
           number -> number*10;

    static //function after function
    Function<Integer,Integer> addBy1AndThenMultiplyBy10 =
            incrementOneFunction.andThen(multipleBy10Function);






    //end of _Function class
}
