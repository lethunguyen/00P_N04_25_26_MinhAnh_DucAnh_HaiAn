package schoolWork.test;

import schoolWork.src.Time;

public class TimeTest {
    public static void Tests() {
        Time t1 = new Time();
        Time t2 = new Time(10);
        Time t3 = new Time(10, 30);
        Time t4 = new Time(23, 59, 59);

        System.out.println("Test default constructor:");
        t1.displayTime();  // expect 00:00:00

        System.out.println("Test 1-arg constructor:");
        t2.displayTime();  // expect 10:00:00

        System.out.println("Test 2-arg constructor:");
        t3.displayTime();  // expect 10:30:00

        System.out.println("Test 3-arg constructor:");
        t4.displayTime();  // expect 23:59:59
    } 
}
