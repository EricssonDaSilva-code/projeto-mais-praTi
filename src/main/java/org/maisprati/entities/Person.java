package org.maisprati.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Person {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    protected String name;
    protected String phonenumber;
    protected LocalDateTime registrationdate;
    protected LocalDate changedate;

    public Person() {

    }

    public Person(String name, String phonenumber, LocalDateTime registrationdate) {
        this.name = name;
        this.phonenumber = String.valueOf(phonenumber.replaceAll("[^0-9]", ""));
        this.registrationdate = registrationdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getPhonenumber() {
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

    public LocalDate getChangedate() {
        return changedate;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(phonenumber, person.phonenumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phonenumber);
    }

    @Override
    public String toString() {
        return "Name = " + name + "\n"
                + "Phone = " + phonenumber + "\n"
                + "Registration Date = " + registrationdate;

    }
}
