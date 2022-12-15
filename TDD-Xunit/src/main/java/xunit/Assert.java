package xunit;

public class Assert {
    public static void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual))
            throw new RuntimeException("expected <" + expected + "> but was <" + actual + ">");
    }
}
