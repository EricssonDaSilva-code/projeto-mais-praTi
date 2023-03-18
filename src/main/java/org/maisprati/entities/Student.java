package org.maisprati.entities;

import java.time.LocalDateTime;

public class Student extends Individual {

    private float finalNote;

    public Student() {

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
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Nome: " + name +
                ", " + "numero de telefone: " + phonenumber +
                ", " + "data de cadastro: " + registrationdate.format(dateTimeFormatter) +
                ", " + "data de alteração: " + changedate.format(dateTimeFormatter) +
                ", " + "nota final: " + finalNote;
    }
}
