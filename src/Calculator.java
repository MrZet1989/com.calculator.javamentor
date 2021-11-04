import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    private int number1, number2;
    private char operation;
    private double result;
    private boolean isArabicNumber;
    private RomanArab dictionary = new RomanArab();


    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввод: ");
        String input = scanner.nextLine();
        input = input.toUpperCase();
        operation = findOperation(input);
        number1 = findNumber1(input);
        number2 = findNumber2(input);
        calculate();
    }


    private char findOperation(String input) {
        if (input.contains("+") && !input.startsWith("+") && !input.endsWith("+")) {
            return '+';
        } else if (input.contains("-") && !input.startsWith("-") && !input.endsWith("-")) {
            return '-';

        } else if (input.contains("*") && !input.startsWith("*") && !input.endsWith("*")) {
            return '*';
        } else if (input.contains("/") && !input.startsWith("/") && !input.endsWith("/")) {
            return '/';
        } else throw new InputMismatchException("Нету операции");
    }


    private int findNumber1(String input) {
        String number = input.substring(0, input.indexOf(operation));
        for (int i = 1; i <= 10; i++) {
            if (number.equals(String.valueOf(i))) {

                isArabicNumber = true;
                return Integer.valueOf(number);


            }
        }
        if (dictionary.checkRoman(number)) {
            isArabicNumber = false;
            return dictionary.romanArab(number);
        }
        throw new InputMismatchException("Ввод неправильный");
    }

    private int findNumber2(String input) {
        String number = input.substring(input.indexOf(operation) + 1);
        for (int i = 1; i <= 10; i++) {
            if (number.equals(String.valueOf(i))) {
                if (isArabicNumber) {
                    return Integer.valueOf(number);
                } else {
                    throw new InputMismatchException("неправильный формат");
                }

            }
        }
        if (dictionary.checkRoman(number)) {
            if (!isArabicNumber) {
                return dictionary.romanArab(number);
            } else {
                throw new InputMismatchException("неправильный формат");
            }
        }

        throw new InputMismatchException("Ввод неправильный");
    }


    private void calculate() {
        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
        }


        if (result % 1 == 0) {
            if (isArabicNumber) {
                System.out.println("Результат: \n" + result);
            } else {
                System.out.println("Результат: \n " + RomanArab.arabToRoman((int) result));
            }
        } else {
            if (isArabicNumber) {
                System.out.println("Результат: \n" + result);
            }


        }

    }

}
