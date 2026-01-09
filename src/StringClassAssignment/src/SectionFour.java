import java.util.Scanner;

public class SectionFour {
    /*
    Math Class
        12. Math Operations
            ○ Write a program to take two numbers as input and perform the following:
                ■ Calculate their power (x^y).
                ■ Find the square root of both numbers.
                ■ Calculate the absolute difference between them.
        13. Random Number Generation
        ○ Generate 10 random integers between 1 and 100 using the Math.random()
        method.
        14. Circle Calculations
        ○ Create a program to calculate the area and circumference of a circle using
        Math.PI and Math.pow().
        15. Number Rounding
        ○ Write a program to demonstrate the use of Math.ceil(), Math.floor(), and
        Math.round() with a floating-point number.
        16. Trigonometric Functions
        ○ Write a program to calculate the sine, cosine, and tangent values for angles
        between 0° and 360°.
     */
    static  void problem_12(){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc .nextInt();
        double result = Math.pow(x,y);
        System.out.println("Power: "+result);
        double sq_x = Math.sqrt(x);
        double sq_y = Math.sqrt(y);
        System.out.println("Square Root: "+sq_x+sq_y);
        System.out.println("absolute Diff: "+ Math.abs(x-y));
        sc.close();
    }

    static  void problem_13(){
        for(int i=0;i<10;i++){
            int random = (int)(Math.random()*100) + 1;
            System.out.println(random);
        }
    }

    static  void problem_14(){
        Scanner sc = new Scanner(System.in);
        int radius = sc.nextInt();
        double area = Math.PI * Math.pow(radius,2);
        double circumference = Math.PI * 2 * radius;
        System.out.println("Area: "+area+"Circumference: "+ circumference);
    }

    static void problem_15(){
        float f = 9.99F;
        System.out.println("Ceil "+Math.ceil(f));
        System.out.println("Floor "+Math.floor(f));
        System.out.println("Round "+Math.round(f));
    }
    static void problem_16(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Angle Between 0 to 360");
        double angle = sc.nextDouble();
        System.out.println("Sine: "+Math.sin(angle));
        System.out.println("Cosine: "+Math.cos(angle));
        System.out.println("Tangent: "+Math.tan(angle));
    }
}
