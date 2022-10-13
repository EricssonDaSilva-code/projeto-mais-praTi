package org.maisprati.application;

import org.maisprati.entities.Person;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Scanner sc = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        Person person = new Person();



        System.out.println("========================= BEM VINDO! =========================");
        System.out.println("======================= ER SYSTEM V0.1 =======================");

        boolean r = true;
        while (r) {
            System.out.println("===================== ESCOLHA UMA OPÇÂO ======================");
            System.out.println(" 0 - SAIR \n " +
                    "1 - CADASTRAR PESSOA/ALUNO \n " +
                    "2 - MOSTRAR LISTA DE PESSOAS/ALUNOS \n " +
                    "3 - ATUALIZAR DADOS \n " +
                    "4 - EXCLUIR PESSOA/ALUNO ");
            System.out.print(" -> ");
            int menu = sc.nextInt();
            if (menu == 0) {
                r = false;
            }

            else if (menu == 1) {
                System.out.println("======================= OPÇÂO 1 - CADASTRAR ========================");
                System.out.println("========================= TELA DE CADASTRO =========================");
                System.out.print("Nome: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Telefone: ");
                String phoneNumber = sc.nextLine();
                personList.add(new Person(name, phoneNumber, LocalDateTime.now()));

            }

            else if (menu == 2) {
                System.out.println("========================= OPÇÂO 2 - MOSTRAR LISTA =========================");
                System.out.println("========================= LISTA DE PESSOAS CADASTRADAS =========================");
                for (Person p : personList) {
                    System.out.println(p);
                }
            }

            else if (menu == 3) {
                System.out.println("========================= OPÇÂO 3 - ALTUALIZAR DADOS =========================");
                System.out.println("========================= ESCOLHA UMA PESSOA =========================");
                System.out.print("Digite o nome da pessoa: ");
                sc.nextLine();
                String name = sc.nextLine();
                for (Person p : personList) {
                    if (p.getName().matches(name)) {
                        System.out.println(p);
                    }
                }
            }

        }

    }
}
