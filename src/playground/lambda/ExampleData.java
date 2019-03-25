package playground.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExampleData {
    public static List createPersons() {
        List<Person> persons = new ArrayList<Person>() {{
           add(new Person("Max Mueller",
                   LocalDate.of(1985,12,1),
                   Person.Sex.MALE,
                   "max@digital.newground"));
           add(new Person("Sina South",
                   LocalDate.of(1988,06,13),
                   Person.Sex.FEMALE,
                   "sina@digital.newground"));
           add(new Person("Herbert Horst",
                   LocalDate.of(1950,2,2),
                   Person.Sex.MALE,
                   "hh@digital.newground"));
           add(new Person("Lisa Loud",
                   LocalDate.of(1995,4,20),
                   Person.Sex.FEMALE,
                   "hh@digital.newground"));
        }};

        return persons;
    }

}
