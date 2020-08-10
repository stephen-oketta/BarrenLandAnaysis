package main.java;

import java.util.Scanner;

public class App {
    private static Analyzer analyzer;
    private static InputProcessor processor;

    static {
        analyzer = new Analyzer();
        processor = new InputProcessor();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = null;

        while (true) {
            System.out.print("Enter the barren land coordinates ('quit' to exit): ");
            input = sc.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            int[][] processedInput = processor.getInput(input);

            if (processedInput == null) {
                System.out.println("Invalid input: " + input);
            } else {
                 System.out.println("Area: " + analyzer.getArea(processedInput));
            }
        }
    }
}
