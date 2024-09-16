package ee.ivkhkee;

public class App {
    public void run(){
        System.out.println("Демо программа хранения данных работников");

        Address address = new Address("Tallinn","Zalupkina","4a","4");
        Person person = new Person("Ivan","Ivanov",2000,10,11,"5654645645",address);

        Employee employee = new Employee();
        employee.setPosition("Director");
        employee.setSalary("3000");
        employee.setPerson(person);
        System.out.printf("Работник:%n %s %s%n %d лет%n %s%n %s%n Должность: %s%n Зарплата: %s%n",
                employee.getPerson().getFirstName(),
                employee.getPerson().getLastName(),
                employee.getPerson().getAge(),
                employee.getPerson().getPhone(),
                employee.getPerson().getAddress().getCity(),
                employee.getPosition(),
                employee.getSalary());

    }
}
