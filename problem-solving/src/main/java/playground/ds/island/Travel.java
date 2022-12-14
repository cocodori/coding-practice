package playground.ds.island;

/**
 * 자료구조의 이해 예제
 */
public class Travel {
    private Node start;

    public Travel() {
        this.start = null;
    }

    public class Node {
        private char name;
        private Node left;
        private Node right;

        public Node(char newIsland, Node left, Node right) {
            this.name = newIsland;
            this.left = left;
            this.right = right;
        }
    }

    /*
                          H
                       /     \
                      F       S
                     / \     / \
                    U  E    Z   K
                   /  /          \
                  N  A            Y
                      \
                      T
     */
    public Node map() {
        Node n1 = new Node('H', null, null);
        Node n2 = new Node('F', null, null);
        Node n3 = new Node('S', null, null);
        Node n4 = new Node('U', null, null);
        Node n5 = new Node('E', null, null);
        Node n6 = new Node('Z', null, null);
        Node n7 = new Node('K', null, null);
        Node n8 = new Node('N', null, null);
        Node n9 = new Node('A', null, null);
        Node n10 = new Node('Y', null, null);
        Node n11 = new Node('T', null, null);

        n1.left = n2; n1.right = n3;
        n2.left = n4; n2.right = n5;
        n3.left = n6; n3.right = n7;
        n4.left = n8;
        n5.left = n9;
        n7.right = n10;
        n9.right = n11;

        return n1;
    }

    public void aCourse(Node n) {
        if (n == null) return;
        System.out.print(n.name + "-> ");
        aCourse(n.left);
        aCourse(n.right);
    }

    public void bCourse(Node n) {
        if (n == null) return;

        bCourse(n.left);
        System.out.print(n.name + "-> ");
        bCourse(n.right);
    }

    public void cCourse(Node n) {
        if (n == null) return;
        cCourse(n.left);
        cCourse(n.right);
        System.out.print(n.name + "-> ");
    }

    public static void main(String[] args) {
        Travel t = new Travel();
        t.start = t.map();
        System.out.print("A Course: ");
        t.aCourse(t.start);

        System.out.print("\nB Course: ");
        t.bCourse(t.start);

        System.out.print("\nC Course: ");
        t.cCourse(t.start);
    }
}
