package schoolWork.test;

import schoolWork.src.Recursion;

public class RecursionTest {
    public static void Tests() {
        System.out.println("  ===Fibonacci Test===\n");

        System.out.println("F(0) = " + Recursion.fib(0));
        System.out.println("F(1) = " + Recursion.fib(1));
        System.out.println("F(10) = " + Recursion.fib(10));

        int n = 15;
        System.out.println("day" + n + "so dau tien");
        for(int i = 0; i < n; i++) {
            System.out.print(Recursion.fib(i) + " ");
        }
        System.out.println();
    }
    
}
