package org.maisprati.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Student extends Person {

    private float finalNote;

    public Student() {

    }

    public Student(float finalNote) {
        this.finalNote = finalNote;
    }

    public Student(String name, String phonenumber, LocalDateTime registrationdate, LocalDateTime changedate, float finalNote) {
        super(name, phonenumber, registrationdate, changedate);
        this.finalNote = finalNote;
    }

    public float getFinalNote() {
        return finalNote;
    }

    public void setFinalNote(float finalNote) {
        this.finalNote = finalNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(phonenumber, student.phonenumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phonenumber);
    }

    @Override
    public String toString() {
        return "Nome: " + name +
                ", " + "numero de telefone: " + phonenumber +
                ", " + "data de cadastro: " + registrationdate +
                ", " + "data de auteração: " + changedate +
                ", " + "nota final: " + finalNote;
    }


}
