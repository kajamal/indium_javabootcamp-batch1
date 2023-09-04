public class CommandLineCalculator {
        public static void main(String[] args) {

        int firstnumber = Integer.valueOf(args[0]);
        char operator = args[1].charAt(0);
        int secondnumber = Integer.valueOf(args[2]);

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
            default:
                System.out.println("invalid operator");


        }
    }
}
