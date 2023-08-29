import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the First Number:");
        int firstnumber = s.nextInt();
        System.out.println("Enter the Second number:");
        int secondnumber = s.nextInt();
        System.out.println("Choose the operator: +,-,*,/");
        int operator = s.next().charAt(0);
        switch (operator) {
            case '+':
                System.out.println("The final result: " + (firstnumber + secondnumber));
                break;
            case '-':
                System.out.println("The final result: " + (firstnumber - secondnumber));
                break;
            case '*':
                System.out.println("The final result: " + (firstnumber * secondnumber));
                break;
            case '/':
                System.out.println("The final result: " + (firstnumber / secondnumber));
                break;

        }
    }
}


