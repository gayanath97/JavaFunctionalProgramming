package streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._stream.Gender.*;

public class _stream {
    public static void main(String[] args) {

        List<Person> people;
        people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alica", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println("--------------------------");
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = x -> System.out.println(x);

        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);
        System.out.println("--------------------------");
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);
        System.out.println("--------------------------");

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        boolean containsOnlyFemale = people.stream()
                .allMatch(personPredicate);
        System.out.println(containsOnlyFemale);
        System.out.println("--------------------------");
        boolean containsFemale = people.stream()
                .anyMatch(personPredicate);
        System.out.println(containsFemale);



        //end main
    }

    static class Person {
        private String name;
        public Gender gender;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }


    //end _stream class
}
