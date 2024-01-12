import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateEx {
    public static void main(String[] args) {
        List<Main.Person> people;
        people = List.of(
                new Main.Person("John", Main.Gender.MALE),
                new Main.Person("Maria", Main.Gender.FEMALE),
                new Main.Person("Aisha", Main.Gender.FEMALE),
                new Main.Person("Alex", Main.Gender.MALE),
                new Main.Person("Alica", Main.Gender.FEMALE)
        );
        Predicate<Main.Person> personPredicate = person -> Main.Gender.FEMALE.equals(person.gender);
        List<Main.Person> females2=people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
        females2.forEach(System.out::println);
    }
    static class Person{
        private String name;
        private Main.Gender gender;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }

        public Person(java.lang.String name, Main.Gender gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    enum Gender{
        MALE,FEMALE
    }
}
