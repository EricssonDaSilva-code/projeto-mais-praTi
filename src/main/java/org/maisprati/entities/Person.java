package org.maisprati.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Person {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    protected String name;
    protected String phonenumber;
    protected LocalDateTime registrationdate;
    protected LocalDateTime changedate;

    public Person() {

    }

    public Person(String name, String phonenumber, LocalDateTime registrationdate, LocalDateTime changedate) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.registrationdate = registrationdate;
        this.changedate = changedate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public LocalDateTime getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(LocalDateTime registrationdate) {
        this.registrationdate = registrationdate;
    }

    public LocalDateTime getChangedate() {
        return changedate;
    }

    public void setChangedate(LocalDateTime changedate) {
        this.changedate = changedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(phonenumber, person.phonenumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phonenumber);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", registrationdate=" + registrationdate +
                ", changedate=" + changedate +
                '}';
    }
}
