package ee.ivkhkee;

import java.util.Scanner;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private Employee[] employees = new Employee[100];
    private EmployeeManage employeeManage = new EmployeeManage();

    public void run(){
        boolean repeat = true;
        System.out.println("Отдел кадров");
        System.out.println("----------------------");
        do {
            System.out.println("Список задач:");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить работника");
            System.out.println("2. Список всех работников");
            System.out.println("3. Работкник по имени и фамилии");
            System.out.println("4. Редактировать запись");
            System.out.print("Выберите задачу: ");
            int task = scanner.nextInt(); scanner.nextLine();
            switch (task) {
                case 0:
                    System.out.println("Выход из программы");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("Выбрана 1 задача");
                    Employee employee = employeeManage.create(employeeManage.initialize());
                    for (int i = 0; i < employees.length; i++) {
                        if(employees.length == 0){
                            employees[i] = employee;
                            break;
                        }
                        if (employees[i] != null){continue;}
                        employees[i] = employee;
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Выбрана 2 задача");
                    employeeManage.list(employees);
                    break;
                case 3:
                    System.out.println("Выбрана 3 задача");
                    System.out.print("Имя работника: ");
                    String name = scanner.nextLine();
                    System.out.print("Фамилия работника: ");
                    String surname = scanner.nextLine();
                    employeeManage.printEmployee(name, surname, employees);
                    break;
                case 4:
                    System.out.println("Выбрана 4 задача");
                    break;
                default:
                    System.out.println("Выбрана несуществующая задача");
                    break;
            }
        }while (repeat);
        System.out.println("До свидания! :)");
    }


}
