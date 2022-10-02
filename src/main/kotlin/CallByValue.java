import java.util.HashMap;

public class CallByValue {

    interface Alphabet { }

    class A implements Alphabet { }

    class B implements Alphabet { }

    String a = "a";

    public void some(String a) {
        a = "b";
        System.out.println("some().a="+a);
    }

    public static void main(String[] args) {
        String a = "a";
        CallByValue callByValue = new CallByValue();
        System.out.println(callByValue.a);
        callByValue.some(callByValue.a);
        System.out.println(callByValue.a);

        HashMap<String, String> map = new HashMap<>();
        map.put("A", "A");
        String b = "";
        for (String m : map.values()) {
            b = m;
        }

        System.out.println(b);
    }



}
