package playground.problem.effectivejava.synchronize;

public class Example4 {
    private static volatile int nextSerialNumber = 0;

    public static int generateSerialNumber() {
        return nextSerialNumber++;
    }
}
