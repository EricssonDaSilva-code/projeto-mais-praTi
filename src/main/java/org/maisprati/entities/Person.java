package org.maisprati.entities;

import java.time.LocalDateTime;

public class Person extends Individual {

    public Person() {
    }

    public Person(String name, String phonenumber, LocalDateTime registrationdate, LocalDateTime changedate) {
        super(name, phonenumber, registrationdate, changedate);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
