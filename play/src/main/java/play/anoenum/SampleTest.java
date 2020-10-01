package play.anoenum;

public class SampleTest {
    @NyTest public static void m1() {}
    public static void m2() {}
    @NyTest public static void m3() {
        throw new RuntimeException("Boom");
    }
    public static void m4(){}
    @NyTest public void m5() {}
    public static void m6() {}
    @NyTest public static void m7() {
        throw new RuntimeException("Crash");
    }
    public static void m8() {}
}
