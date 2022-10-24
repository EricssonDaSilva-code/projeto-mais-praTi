package org.maisprati.application;

import org.maisprati.application.repositories.Repository;
import org.maisprati.entities.Person;
import org.maisprati.entities.Student;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public void Start() {
        //inicialização da nossa classe Scanner
        int option;
        Scanner sc = new Scanner(System.in);

        //atributos usados
        String name;
        String phoneNumber;
        float finalNote;
        LocalDateTime registrationDate, changeDate;

        //construtores
        Person newPerson = new Person();
        Student newStudent = new Student();
        Repository objectRepository = new Repository<Person>();


        do {
            //menu de interação com o usuário
            System.out.println("********************************************************");
            System.out.println("*   DIGITE O NÚMERO DE QUAL OPERAÇÃO DESEJA EFETUAR    *");
            System.out.println("********************************************************");
            System.out.println("*            1 - Cadastrar Pessoa ou Aluno             *");
            System.out.println("*            2 - Listar                                *");
            System.out.println("*            3 - Atualizar dados                       *");
            System.out.println("*            4 - Deletar                               *");
            System.out.println("*            5 - Encerrar programa                     *");
            System.out.println("********************************************************");
            System.out.print("Digite aqui a operação:");

            option = sc.nextInt();

            //função que limpa o buffer
            sc.nextLine();

            switch (option) {

                case 1:
                    //apenas leitura de dados
                    System.out.println("Nome: ");
                    name = sc.nextLine();
                    System.out.println("Telefone: ");
                    phoneNumber = sc.nextLine();
                    System.out.println("Nota final: ");
                    finalNote = Integer.parseInt(sc.nextLine());

                    //construção de novo aluno e pessoa para inserção dos dados
                    registrationDate = LocalDateTime.now();
                    changeDate = LocalDateTime.now();
                    newStudent = new Student(name, phoneNumber, registrationDate, changeDate, finalNote);
                    newPerson = new Person(name, phoneNumber, registrationDate, changeDate);

                    //função que faz a diferenciação entre salvar Pessoa ou Aluno
                    if (finalNote != 0) {
                        objectRepository.addStudent(newStudent);
                    } else {
                        objectRepository.addPerson(newPerson);
                    }
                    break;

                case 2:
                    //lista todos os individuos inseridos como Alunos ou Pessoas
                    objectRepository.listStudent();
                    objectRepository.listPerson();
                    break;

                case 3:
                    //menu usuário escolhe se irá editar Aluno ou Pessoa
                    System.out.println("Você deseja alterar aluno ou pessoa: ");
                    String select = sc.next().toUpperCase(Locale.ROOT);
                    //função que diferencia entre aluno ou pessoa
                    if ("ALUNO".equals(select)) {
                        objectRepository.listStudent();
                    } else if ("PESSOA".equals(select)) {
                        objectRepository.listPerson();
                    } else {
                        option = 3;
                    }
                    //menu que mostra qual a opção que o usuário deseja efetuar
                    System.out.println("Informe com base na numeração, qual individuo você deseja alterar: ");
                    int num = sc.nextInt();
                    if ("ALUNO".equals(select)) {
                        Student student = (Student) objectRepository.studentList.get(num - 1);
                        System.out.println("Informe com base na numeração, qual atributo deseja alterar: ");
                        System.out.println("**********************************");
                        System.out.println("* 1 - Alterar nome               *");
                        System.out.println("* 2 - Alterar telefone           *");
                        System.out.println("* 3 - Alterar nota final         *");
                        System.out.println("**********************************");
                        int alterarOpcao = sc.nextInt();
                        //faz a diferenciação para a escolha de qual atributo que irá ser editado
                        if (alterarOpcao == 1) {
                            System.out.println("Nome: ");
                            name = sc.nextLine();
                            student.setName(name);
                        } else if (alterarOpcao == 2) {
                            System.out.println("Telefone: ");
                            phoneNumber = sc.nextLine();
                            student.setPhonenumber(phoneNumber);
                        } else if (alterarOpcao == 3) {
                            System.out.println("Nota final: ");
                            finalNote = sc.nextFloat();
                            student.setFinalNote(finalNote);
                        } else {
                            System.out.println("Digite um numero válido");
                        }
                    } else if ("PESSOA".equals(select)) {
                        Person person = (Person) objectRepository.personList.get(num - 1);
                        System.out.println("Informe com base na numeração, qual atributo deseja alterar: ");
                        System.out.println("**********************************");
                        System.out.println("* 1 - Alterar nome               *");
                        System.out.println("* 2 - Alterar telefone           *");
                        System.out.println("**********************************");
                        int alterarOpcao = sc.nextInt();
                        sc.nextLine();
                        if (alterarOpcao == 1) {
                            System.out.println("Nome: ");
                            name = sc.nextLine();
                            person.setName(name);
                        } else if (alterarOpcao == 2) {
                            System.out.println("Telefone: ");
                            phoneNumber = sc.nextLine();
                            person.setPhonenumber(phoneNumber);
                        } else {
                            System.out.println("Digite um numero válido");
                        }
                        break;


                    }
                case 4:
                    //menu de escolha entre Aluno ou Pessoa para ser deletado
                    System.out.println("Você deseja deletar um aluno ou pessoa: ");
                    String delIndividuo = sc.next().toUpperCase();
                    //função que diferencia entre aluno ou pessoa
                    if ("ALUNO".equals(delIndividuo)) {
                        objectRepository.listStudent();
                    } else if ("PESSOA".equals(delIndividuo)) {
                        objectRepository.listPerson();
                    } else {
                        System.out.println("Digite um aluno ou pessoa");
                    }
                    //menu que mostra qual a opção que o usuário deseja efetuar
                    System.out.println("Informe com base na numeração, qual Aluno/Pessoa você deseja deletar: ");
                    int delNumIndividuo = sc.nextInt();
                    //função que remove o individuo escolhido
                    if ("ALUNO".equals(delIndividuo)) {
                        ((Repository<?>) objectRepository).studentList.remove(delNumIndividuo - 1);
                    } else if ("PESSOA".equals(delIndividuo)) {
                        objectRepository.personList.remove(delNumIndividuo - 1);
                    }
                    break;
                case 5:
                    System.out.println("Seu programa está sendo encerrado!");
                    //o método System.exit encerra o processamento do JVM. Passamos o valor 0 para exit() para indicar que ele irá terminar sem nenhum erro.
                    //se for passado um número diferente de 0 (como 1 ou -1) o compilador entende que irá terminar o programa com algum erro ou mensagem.
                    System.exit(0);
                    break;
                //o default é chamado caso adicionem um número que não existe
                default:
                    System.out.println("\nOpção inválida!Digite um dos números acima.");
            }
        }
        while (option != 0); //aqui ele sempre vai fazer o que estiver no "DO" automaticamente
    }
}


