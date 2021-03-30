package com.company;

import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class ClinicService {
//    private Appointment[] _appointments;
//    private Employee[] _employees;
    private ArrayList<Appointment> _appointments = new ArrayList<Appointment>();
    private ArrayList<Employee> _employees = new ArrayList<Employee>();


    public void Menu(){
        Scanner scanner = new Scanner(System.in);
        Medic medic = new Medic();
        Specialization general = new Specialization();
        Insurance basic = new Insurance("Basic", 0.7, 12);
        Specialization chir = new Specialization("Chirurg", 3);
        Medic x = new Medic("John","Doe",28, "Berceni", 1000, chir);
        _employees.add(x);
        Boolean first = true;
        while(1>0){
            if(first) {
                System.out.println("Welcome. Please select an option:");
                System.out.println("1) See appointments");
                System.out.println("2) See employees");
                System.out.println("3) Add appointment");
                System.out.println("4) Exit");
                first = false;
            }
            else{
                System.out.println();
                System.out.println("1) See appointments");
                System.out.println("2) See employees");
                System.out.println("3) Add appointment");
                System.out.println("4) Exit");
            }
            int option = scanner.nextInt();

            if(option == 1){
                for (Appointment app : _appointments){
                    System.out.print("Client: ");
                    System.out.print(app.getClient().getFirstName() + " ");
                    System.out.println(app.getClient().getLastName());

                    System.out.print("Medic: ");
                    System.out.print(app.getMedic().getFirstName() + " ");
                    System.out.println(app.getMedic().getLastName());

                    System.out.print("Cost: ");
                    System.out.println(app.getCost());

                    System.out.print("Date: ");
                    System.out.println(app.getDate());
                }
            }
            else if (option == 2){
                for (Employee emp : _employees){
                    System.out.print(emp.getFirstName() + " ");
                    System.out.print(emp.getLastName() + " ");
                    System.out.print(emp.getClass() + " ");
                    System.out.println(emp.getHireDate());
                }
            }
            else if(option == 3) {
                System.out.println("Choose a medic: ");
                for (Employee emp : _employees){
                    if(emp.getClass() == medic.getClass()) {
                        System.out.println(emp.getLastName());
                    }
                }
                System.out.println();
                String name = scanner.nextLine();
                Medic chosenMedic = (Medic) _employees.get(0);
                for (Employee emp : _employees){
                    if(emp.getLastName().equals(name) && emp.getClass() == medic.getClass()) {
                        chosenMedic = ((Medic) emp);
                        break;
                    }
                }
                System.out.println("Client first name: ");
                String fname = scanner.nextLine();
                System.out.println("Client last name: ");
                String lname = scanner.nextLine();
                System.out.println("Client age: ");
                int age = scanner.nextInt();

                Client client = new Client(fname, lname, age, basic);

                _appointments.add(new Appointment(chosenMedic, client, new Date(), 30));


            }
            else if(option == 4){
                System.out.println("Goodbye!");
                return;
            }
            else{
                System.out.println("Invalid option");
            }


        }


    }

}
