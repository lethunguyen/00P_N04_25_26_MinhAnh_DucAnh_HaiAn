package schoolWork.src;

public class Recursion {
    public static int fib(int i) {
        // FIBONACCI
        if(i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } 
        return fib(i-1) + fib(i-2);
    }
}
