package ee.ivkhkee;

import ee.ivkhkee.model.Employee;
import ee.ivkhkee.service.EmployeeManage;
import ee.ivkhkee.interfaces.Input;

public class App {
    private Input input; // Используем Input
    private Employee[] employees = new Employee[100];
    private EmployeeManage employeeManage; // Убираем инициализацию здесь

    // В конструктор теперь передается Input
    public App(Input input) {
        this.input = input;
        this.employeeManage = new EmployeeManage(input); // Передаем Input в EmployeeManage
    }

    public void run() {
        boolean repeat = true;
        System.out.println("Отдел кадров");
        System.out.println("----------------------");
        do {
            System.out.println("Список задач:");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить работника");
            System.out.println("2. Список всех работников");
            System.out.println("3. Работник по имени и фамилии");
            System.out.println("4. Редактировать запись");
            System.out.print("Выберите задачу: ");
            int task = Integer.parseInt(input.nextLine()); // Используем input вместо scanner
            switch (task) {
                case 0:
                    System.out.println("Выход из программы");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("Выбрана 1 задача");
                    Employee employee = employeeManage.create(employeeManage.initialize());
                    for (int i = 0; i < employees.length; i++) {
                        if (employees.length == 0) {
                            employees[i] = employee;
                            break;
                        }
                        if (employees[i] != null) {
                            continue;
                        }
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
                    String name = input.nextLine(); // Используем input вместо scanner
                    System.out.print("Фамилия работника: ");
                    String surname = input.nextLine(); // Используем input вместо scanner
                    employeeManage.printEmployee(name, surname, employees);
                    break;
                case 4:
                    System.out.println("Выбрана 4 задача");
                    // Код для редактирования записи
                    break;
                default:
                    System.out.println("Выбрана несуществующая задача");
                    break;
            }
        } while (repeat);
        System.out.println("До свидания! :)");
    }

}
