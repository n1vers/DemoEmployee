package ee.ivkhkee;

import ee.ivkhkee.interfaces.Input;
import ee.ivkhkee.model.Employee;
import ee.ivkhkee.service.EmployeeManage;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class AppTest {

    private Input inputMock; // Мок объекта Input
    private ByteArrayOutputStream outContent; // Для перехвата вывода консоли
    private final PrintStream originalOut = System.out; // Оригинальный System.out
    private Employee[] employees;

    @BeforeEach
    public void setUp() {
        // Мокируем Input
        inputMock = Mockito.mock(Input.class);

        // Создаем массив работников для теста
        employees = new Employee[100];

        // Перехватываем вывод в консоль
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        // Восстанавливаем оригинальный System.out после каждого теста
        System.setOut(originalOut);
    }

    @Test
    public void testExitProgram() {
        // Настраиваем поведение nextLine для завершения программы
        when(inputMock.nextLine()).thenReturn("0");

        // Создаем объект App с мокированным input
        App app = new App(inputMock);

        // Запускаем метод run
        app.run();

        // Проверяем, что программа завершилась с правильным сообщением
        assertTrue(outContent.toString().contains("До свидания!"));
    }

    @Test
    public void testInvalidTaskNumber() {
        // Настраиваем поведение nextLine для неверного ввода и последующего завершения программы
        when(inputMock.nextLine()).thenReturn("5", "0"); // Сначала неверный ввод, затем завершение

        // Создаем объект App с мокированным input
        App app = new App(inputMock);

        // Запускаем метод run
        app.run();

        // Проверяем, что программа выдала сообщение о неверном номере задачи
        assertTrue(outContent.toString().contains("Выбрана несуществующая задача") && outContent.toString().contains("До свидания!"));
    }

    @Test
    public void testAddEmployee() {
        // Настраиваем последовательность ввода для добавления нового работника и завершения программы
        when(inputMock.nextLine()).thenReturn("1", "Ivan", "Ivanov", "Developer", "5000", "12", "5", "1990", "Tallinn", "Main street", "10", "5", "0");

        // Создаем объект App с мокированным input
        App app = new App(inputMock);

        // Запускаем метод run
        app.run();

        // Проверяем, что работник был добавлен в массив
        Employee addedEmployee = app.employees[0];
        assertTrue(addedEmployee.getPerson().getFirstName().equals("Ivan"));
        assertTrue(outContent.toString().contains("Добавлен работник"));
    }

    @Test
    public void testListEmployees() {
        // Добавляем одного работника вручную
        employees[0] = new EmployeeManage().create(new String[]{
                "Ivan", "Ivanov", "Developer", "5000", "12", "5", "1990", "Tallinn", "Main street", "10", "5", "555-1234"
        });

        // Настраиваем последовательность ввода для просмотра списка работников и завершения программы
        when(inputMock.nextLine()).thenReturn("2", "0");

        // Создаем объект App с мокированным input
        App app = new App(inputMock);
        app.employees = this.employees; // Подставляем массив работников

        // Запускаем метод run
        app.run();

        // Проверяем, что список работников был выведен
        assertTrue(outContent.toString().contains("Список работников"));
        assertTrue(outContent.toString().contains("Ivan Ivanov"));
    }

    @Test
    public void testFindEmployeeByName() {
        // Добавляем одного работника вручную
        employees[0] = new EmployeeManage().create(new String[]{
                "Ivan", "Ivanov", "Developer", "5000", "12", "5", "1990", "Tallinn", "Main street", "10", "5", "555-1234"
        });

        // Настраиваем последовательность ввода для поиска работника по имени и завершения программы
        when(inputMock.nextLine()).thenReturn("3", "Ivan", "Ivanov", "0");

        // Создаем объект App с мокированным input
        App app = new App(inputMock);
        app.employees = this.employees; // Подставляем массив работников

        // Запускаем метод run
        app.run();

        // Проверяем, что программа нашла и вывела информацию о работнике
        assertTrue(outContent.toString().contains("Ivan Ivanov"));
    }

    @Test
    public void testEditEmployee() {
        // Добавляем одного работника вручную
        employees[0] = new EmployeeManage().create(new String[]{
                "Ivan", "Ivanov", "Developer", "5000", "12", "5", "1990", "Tallinn", "Main street", "10", "5", "555-1234"
        });

        // Настраиваем последовательность ввода для редактирования работника
        when(inputMock.nextLine()).thenReturn("4", "0"); // Ввод задачи редактирования и завершение программы

        // Создаем объект App с мокированным input
        App app = new App(inputMock);
        app.employees = this.employees; // Подставляем массив работников

        // Запускаем метод run
        app.run();

        // Проверяем, что программа вывела сообщение о том, что задача выбрана
        assertTrue(outContent.toString().contains("Выбрана 4 задача"));
    }
}
