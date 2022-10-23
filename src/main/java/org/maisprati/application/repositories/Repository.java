package org.maisprati.application.repositories;

import org.maisprati.entities.Person;
import org.maisprati.entities.Student;

import java.util.ArrayList;

public class Repository<T> {

    String nome;
    String phoneNumber;
    float finalNote;

    Person newPerson = new Person();
    Student newStudent = new Student();

    public ArrayList<Person> personList;
    public ArrayList<Student> studentList;


    public Repository() {
        this.personList = new ArrayList<>();
        this.studentList = new ArrayList<>();
    }

    public void addPerson(Person newPerson) {
        personList.add(newPerson);
    }

    public void addStudent(Student newStudent) {
        studentList.add(newStudent);
    }

    public void listPerson() {
        System.out.println("Lista de Pessoas:");
        //aqui a primeira pessoa adicionada será a 1
        int incremento = 1;
        for (Person person : personList) {
            System.out.print(incremento + "-");
            System.out.println(person);
            //pessoaNaLista.listarPessoa();
            incremento++; //sempre que adicionar uma nova pessoa essa irá receber um número diferente
        }
    }

    public void listStudent() {
        System.out.println("Lista de Alunos:");
        //aqui o primeiro aluno adicionado será a 1
        int incremento = 1;
        for (Student student : studentList) {
            System.out.print(incremento + "-");
            //alunoNaLista.listarAluno();
            System.out.println(student);
            incremento++; //sempre que adicionar um novo aluno esse irá receber um número diferente
            //for percorre toda a classe e pega o toString
        }
    }
}
