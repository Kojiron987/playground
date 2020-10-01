package play.classandobjects;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    private final String name;
    private final LocalDate birthDate;
    private final Sex gender;
    private final int age;
    private final String emailAddress;

    public static class Builder {
        private String name;
        private LocalDate birthDate;
        private Sex gender;
        private int age;
        private String emailAddress;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            age = Period.between(birthDate, LocalDate.now()).getYears();
            return this;
        }

        public Builder gender(Sex gender) {
            this.gender = gender;
            return this;
        }

        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public static Person create(String name, LocalDate birthDate, Sex gender, String emailAddress) {
        return new Builder().name(name).birthDate(birthDate).gender(gender).emailAddress(emailAddress).build();
    }

    private Person(Builder builder) {
        name = builder.name;
        birthDate = builder.birthDate;
        gender = builder.gender;
        age = builder.age;
        emailAddress = builder.emailAddress;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Sex getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String emailAddress() {
        return emailAddress;
    }

    public void printPerson() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        DateTimeFormatter birthDateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        return String.format("Name: %s, Birthday: %s, Gender: %s, Age: %d, Email Address: %s", name,
                birthDateFormatter.format(birthDate), gender, age, emailAddress);
    }
}
