package xunit;

public class WasRun extends TestCase {
    public boolean wasRun;
    public String log;

    public WasRun(String name) {
        super(name);
    }

    public void testMethod() {
        wasRun = true;
        log += " testMethod";

    }

    public void testBrokenMethod() {
        throw new RuntimeException();
    }

    @Override
    public void setUp() {
        log = "setUp";
    }

    @Override
    public void tearDown() {
        log += " tearDown";
    }
}
