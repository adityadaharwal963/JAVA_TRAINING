public class Problem1 {
    // problem 1
    /*
    1. Division Calculator
    Write a program to divide two numbers. If the user enters zero as the denominator,
    throw and handle an ArithmeticException with a meaningful error message.
     */
    public static int  divisionCalculator(int dividend , int divisor){
        try {
            return dividend/divisor;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception :"+e.getMessage());
        } catch (Exception e){
            System.out.println("Unknown error happened :"+ e.getMessage());

        }
        return 0;
    }

}
