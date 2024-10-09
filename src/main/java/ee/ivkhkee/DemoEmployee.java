package ee.ivkhkee;

import ee.ivkhkee.interfaces.Input;
import ee.ivkhkee.tools.ConsoleInput;

import java.util.Scanner;

public class DemoEmployee {
    public static void main(String[] args) {
        Input scanner = new ConsoleInput(new Scanner(System.in));
        System.out.println("JPTV23Employee");
        App app = new App(scanner);
        app.run();
    }
}