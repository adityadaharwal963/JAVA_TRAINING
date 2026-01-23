package PartA;

interface Calculator
{
    double calculate(int a, int b);
}

public class Solution4 {

    public static void main() {
        Calculator addition = (a,b)->a+b;
        Calculator subtraction = (a,b)->a-b;
        Calculator multiplication = (a,b)->a*b;
        Calculator division = (a,b)->a/b;

        System.out.println(addition.calculate(1,2));
        System.out.println(subtraction.calculate(2,2));
        System.out.println(multiplication.calculate(2,2));
        System.out.println(division.calculate(2,2));

    }
}
