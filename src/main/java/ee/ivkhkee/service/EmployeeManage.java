package ee.ivkhkee.service;

import ee.ivkhkee.model.Address;
import ee.ivkhkee.model.Employee;
import ee.ivkhkee.model.Person;
import ee.ivkhkee.interfaces.Input;

public class EmployeeManage {

    private Input input; // Используем Input вместо Scanner

    // В конструктор теперь передается Input
    public EmployeeManage(Input input) {
        this.input = input;
    }

    public void list(Employee[] employees) {
        System.out.println("Список работников");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.printf(
                        "%d. Работник%nИмя: %s,%nФамилия: %s,%nДолжность: %s,%nВозраст: %d,%nЗарплата: %s.%nПроживает по адресу: %s, %s, %s, %s%n",
                        i + 1,
                        employees[i].getPerson().getFirstName(),
                        employees[i].getPerson().getLastName(),
                        employees[i].getPosition(),
                        employees[i].getPerson().Age(),
                        employees[i].getSalary(),
                        employees[i].getPerson().getAddress().getCity(),
                        employees[i].getPerson().getAddress().getStreet(),
                        employees[i].getPerson().getAddress().getHouse(),
                        employees[i].getPerson().getAddress().getRoom()
                );
            }
        }
    }

    public String[] initialize() {
        String[] employeeAttributes = new String[12];
        System.out.print("Имя: ");
        employeeAttributes[0] = input.nextLine();
        System.out.print("Фамилия: ");
        employeeAttributes[1] = input.nextLine();
        System.out.print("Должность: ");
        employeeAttributes[2] = input.nextLine();
        System.out.print("Зарплата: ");
        employeeAttributes[3] = input.nextLine();
        System.out.print("День рождения: ");
        employeeAttributes[4] = input.nextLine();
        System.out.print("Месяц рождения: ");
        employeeAttributes[5] = input.nextLine();
        System.out.print("Год рождения: ");
        employeeAttributes[6] = input.nextLine();
        System.out.print("Номер телефона: ");
        employeeAttributes[11] = input.nextLine();
        System.out.print("Город: ");
        employeeAttributes[7] = input.nextLine();
        System.out.print("Улица: ");
        employeeAttributes[8] = input.nextLine();
        System.out.print("Дом: ");
        employeeAttributes[9] = input.nextLine();
        System.out.print("Квартира: ");
        employeeAttributes[10] = input.nextLine();
        return employeeAttributes;
    }

    public Employee create(String[] employeeAttributes) {
        Address address = new Address();
        address.setCity(employeeAttributes[7]);
        address.setStreet(employeeAttributes[8]);
        address.setHouse(employeeAttributes[9]);
        address.setRoom(employeeAttributes[10]);

        Person person = new Person(
                employeeAttributes[0],
                employeeAttributes[1],
                Integer.parseInt(employeeAttributes[6]),
                Integer.parseInt(employeeAttributes[5]),
                Integer.parseInt(employeeAttributes[4]),
                employeeAttributes[11],
                address
        );

        Employee employee = new Employee(person, employeeAttributes[2], employeeAttributes[3]);

        System.out.printf(
                "Добавлен работник%nИмя: %s,%nФамилия: %s,%nДолжность: %s,%nВозраст: %d,%nЗарплата: %s.%nПроживает по адресу: %s, %s, %s, %s%n",
                employee.getPerson().getFirstName(),
                employee.getPerson().getLastName(),
                employee.getPosition(),
                employee.getPerson().Age(),
                employee.getSalary(),
                employee.getPerson().getPhone(),
                employee.getPerson().getAddress().getCity(),
                employee.getPerson().getAddress().getStreet(),
                employee.getPerson().getAddress().getHouse(),
                employee.getPerson().getAddress().getRoom()
        );
        return employee;
    }

    public void printEmployee(String name, String surname, Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null &&
                    employee.getPerson().getFirstName().equals(name) &&
                    employee.getPerson().getLastName().equals(surname)) {
                System.out.printf(
                        "Работник%nИмя: %s,%nФамилия: %s,%nДолжность: %s,%nВозраст: %d,%nЗарплата: %s.%nПроживает по адресу: %s, %s, %s, %s%n",
                        employee.getPerson().getFirstName(),
                        employee.getPerson().getLastName(),
                        employee.getPosition(),
                        employee.getPerson().Age(),
                        employee.getSalary(),
                        employee.getPerson().getAddress().getCity(),
                        employee.getPerson().getAddress().getStreet(),
                        employee.getPerson().getAddress().getHouse(),
                        employee.getPerson().getAddress().getRoom()
                );
            }
        }
    }
}
