package ee.ivkhkee;

import java.util.Scanner;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private Employee[] employees = new Employee[100];

    public void run() {
        boolean repeat = true;
        System.out.println("Демо программа \"Отдел кадров\"");
        do {
            System.out.println("Список задач:");
            System.out.println("0. Выйти из программы:");
            System.out.println("1. Добавить работника:");
            System.out.println("2. Список работников:");
            System.out.println("3. Работник по имени и фамилии:");
            System.out.println("Выберите задачу:");
            int task = scanner.nextInt();
            scanner.nextLine();

            switch (task) {
                case 0:
                    System.out.println("Выход из программы");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("Выбрана задача 1");
                    createEmployee();
                    break;
                case 2:
                    System.out.println("Выбрана задача 2");
                    // Здесь должен быть код для отображения списка работников
                    break;
                case 3:
                    System.out.println("Выбрана задача 3");
                    // Здесь должен быть код для поиска работника по имени и фамилии
                    break;
                default:
                    System.out.println("Некорректный выбор");
            }
        } while (repeat);
        System.out.println("До свидания!");
    }

    private void createEmployee() {
        System.out.println("Имя:");
        String firstName = scanner.nextLine();
        System.out.println("Фамилия:");
        String lastName = scanner.nextLine();
        System.out.println("Должность:");
        String position = scanner.nextLine();
        System.out.println("Зарплата:");
        String salary = scanner.nextLine();
        System.out.println("День рождения:");
        int birthDay = scanner.nextInt();scanner.nextLine();
        System.out.println("Месяц рождения:");
        int birthMonth = scanner.nextInt();scanner.nextLine();
        System.out.println("Год рождения:");
        int birthYear = scanner.nextInt();scanner.nextLine();
        System.out.println("Номер телефона:");
        String phone = scanner.nextLine();
        System.out.println("Город:");
        String city = scanner.nextLine();
        System.out.println("Улица:");
        String street = scanner.nextLine();
        System.out.println("Номер дома:");
        String house = scanner.nextLine();
        System.out.println("Номер квартиры:");
        String room = scanner.nextLine();

        Address address = new Address(city,street, house, room);
        Person person = new Person(firstName, lastName, birthYear, birthMonth, birthDay, phone, address);

        Employee employee = new Employee();
        employee.setPosition(position);
        employee.setSalary(salary);
        employee.setPerson(person);

        System.out.printf("Работник 1:%n %s %s%n %d лет%n %s%n %s%n Должность: %s%n Зарплата: %s%n",
                employee.getPerson().getFirstName(),
                employee.getPerson().getLastName(),
                employee.getPerson().Age(),
                employee.getPerson().getPhone(),
                employee.getPerson().getAddress().getCity(),
                employee.getPosition(),
                employee.getSalary()
        );
        saveEmployee(employee);
    }
    private void saveEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                System.out.println("Работник успешно сохранен.");
                return;
            }
        }
        System.out.println("Нет свободного места для нового работника.");
        }
    }


