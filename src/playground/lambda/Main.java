package playground.lambda;

import java.util.List;

import static playground.lambda.LambdaTutorialApproaches.*;

public class Main {

    public static void main(String[] args) {
        List<Person> roster = ExampleData.createPersons();

        System.out.println("-------- Approach 1 ----------------");
        printPersonsOlderThan(roster, 40);
        System.out.println("-------- Approach 2 ----------------");
        printPersonsWithinAgeRange(roster,30,40);
        System.out.println("-------- Approach 3 ----------------");
        printPersons(roster, new CheckPersonEligibleForSelectiveService());
        System.out.println("-------- Approach 4 ----------------");
        printPersons(roster, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.gender == Person.Sex.MALE &&
                        p.getAge() >= 18 &&
                        p.getAge() <= 40;            }
        });
        System.out.println("-------- Approach 5 ----------------");
        printPersons(roster,
                (Person p) -> p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 35
                );
        System.out.println("-------- Approach 6 ----------------");
        printPersonsWithPredicate(roster,
                p -> p.getGender() == Person.Sex.FEMALE
                    && p.getAge() >= 18
                    && p.getAge() <= 30
        );
        System.out.println("-------- Approach 7 ----------------");
        processPersons(roster,
                p -> p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 40,
                p -> p.printPerson()
        );


        processPersonsWithFunction(
                roster,
                p -> p.getGender() == Person.Sex.FEMALE
                        && p.getAge() >= 18
                        && p.getAge() <= 30,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
        System.out.println("-------- Approach 8 ----------------");
        processElements(
                roster,
                p -> p.getGender() == Person.Sex.FEMALE
                        && p.getAge() >= 18
                        && p.getAge() <= 30,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );

        System.out.println("-------- Approach 9 ----------------");
        roster
                .stream()
                .filter(
                        p -> p.getGender() == Person.Sex.FEMALE
                                && p.getAge() >= 18
                                && p.getAge() <= 35)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));

    }


    // Approach 3
    private static class CheckPersonEligibleForSelectiveService implements CheckPerson {
        @Override
        public boolean test(Person p) {
            return p.gender == Person.Sex.MALE &&
                    p.getAge() >= 18 &&
                    p.getAge() <= 40;
        }
    }
}
