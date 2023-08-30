import java.util.Scanner;

public class CalculatorMethodApp {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = s.nextInt();
        System.out.println("Enter the second number");
        int b = s.nextInt();
        System.out.println("Choose the operator +,-,/,*");
        char c = s.next().charAt(0);
        switch (c) {
            case '+':
                System.out.println("Final result " + Add(a, b));
            case '-':
                System.out.println("Final result " + sub(a, b));
            case '*':
                System.out.println("Final result " + multply(a, b));
            case '/':
                System.out.println("Final result " + divide(a, b));
            default:
                System.out.println("Invalid operator");

        }


    }


    public static int Add(int a, int b) {

        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int multply(int a, int b) {
        return a * b;

    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
