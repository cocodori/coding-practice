package kotlininaction.ch3;

public class JavaKotlinExtensionPropertyCall {
    public static void main(String[] args) {
        System.out.println(ExampleKt.getLastChar("Java"));

        StringBuilder sb = new StringBuilder("Java?");
        ExampleKt.setLastChar(sb, '!');

        System.out.println(sb);

    }
}
