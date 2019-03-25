package playground.lambda;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.YEARS;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void printPerson() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nName: " + this.name);
        sb.append("\nBirthday: " + this.birthday.toString());
        sb.append("\nGender: " + this.gender.toString());
        sb.append("\nEmail: " + this.emailAddress);
        sb.append("\n" + this.name + " is " + getAge() + " years old.");

        sb.append("\n");
        System.out.println(sb.toString());
    }

    public long getAge() {
        return YEARS.between(birthday, LocalDate.now());
    }
}