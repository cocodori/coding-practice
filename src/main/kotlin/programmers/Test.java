package programmers;

public class Test {
    public static void main(String[] args) {
        new Run().test();
    }
}

class Run {
    public void test() {
        Data data = new Data();
        System.out.println(data.value);
        someMethod(data);
        System.out.println(data.value);
    }

    private void someMethod(Data data) {
        data = null;
    }

}

class Data {
    int value = 0;
}
