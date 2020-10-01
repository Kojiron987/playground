package play.anoenum;

import java.util.ArrayList;
import java.util.List;

public class SampleTest2 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1() {
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() {
        int[] a = new int[0];
        int i = a[1];
    }
    @ExceptionTest(ArithmeticException.class)
    public void m3() { }

    @ExceptionTest(NullPointerException.class)
    @ExceptionTest(ArrayIndexOutOfBoundsException.class)
    public static void m4() {
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }
}
