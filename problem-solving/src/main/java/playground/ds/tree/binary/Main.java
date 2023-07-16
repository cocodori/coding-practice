package playground.ds.tree.binary;

import java.security.Key;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(100, null, null);
        Node<Integer> n2 = new Node<>(200, null, null);
        Node<Integer> n3 = new Node<>(300, null, null);
        Node<Integer> n4 = new Node<>(400, null, null);
        Node<Integer> n5 = new Node<>(500, null, null);
        Node<Integer> n6 = new Node<>(600, null, null);
        Node<Integer> n7 = new Node<>(700, null, null);
        Node<Integer> n8 = new Node<>(800, null, null);

        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        n4.setLeft(n8);

        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setRoot(n1);

        System.out.println("트리 노드 수: " + tree.size(tree.getRoot()) + "\n트리 높이: " + tree.height(tree.getRoot()));
        System.out.println("\n전위순회: ");
        tree.preorder(tree.getRoot());
        System.out.println("\n중위순회: ");
        tree.inorder(tree.getRoot());
        System.out.println("\n후위순회: ");
        tree.postorder(tree.getRoot());
        System.out.println("\n레벨순회: ");
        tree.levelOrder(tree.getRoot());
    }
}

class Node<Key extends Comparable<Key>> {

    private Key item;
    private Node<Key> left;
    private Node<Key> right;

    public Node(Key newItem, Node<Key> left, Node<Key> right) {
        this.item = newItem;
        this.left = left;
        this.right = right;
    }

    public Key getKey() {
        return item;
    }

    public Node<Key> getLeft() {
        return left;
    }

    public Node<Key> getRight() {
        return right;
    }

    public void setLeft(Node<Key> left) {
        this.left = left;
    }

    public void setRight(Node<Key> right) {
        this.right = right;
    }
}

class BinaryTree<Key extends Comparable<Key>> {

    private Node<Key> root;

    public BinaryTree() {
        root = null;
    }

    public Node<Key> getRoot() {
        return root;
    }

    public void setRoot(Node<Key> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void preorder(Node<Key> n) { //전위순회
        if (n != null) {
            System.out.printf(n.getKey() + " "); // 노드 n 방문
            preorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
            preorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
        }
    }

    public void inorder(Node<Key> n) {  //중위순회
        if (n != null) {
            inorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
            System.out.printf(n.getKey() + " "); // 노드 n 방문
            inorder(n.getRight());  // n의 오른쪽 서브트리를 순회하기 위해
        }
    }

    public void postorder(Node<Key> n) {  //후위순회
        if (n != null) {
            postorder(n.getLeft()); // n의 왼쪽 서브트리 순회
            postorder(n.getRight()); // n의 오른쪽 서브트리 순회
            System.out.printf(n.getKey() + " "); // 노드 n 방문
        }
    }

    public void levelOrder(Node<Key> root) { // 레벨순회
        Queue<Node<Key>> q = new LinkedList<>();
        Node<Key> t;
        q.add(root); // 큐에 루트 노드 삽입
        while (!q.isEmpty()) {
            t = q.remove(); // 큐 가장 앞 노드 제거
            System.out.printf(t.getKey() + " "); // 제거된 노드 출력(방문)
            if (t.getLeft() != null) {
                q.add(t.getLeft()); // 큐에 왼쪽 자식 삽입
            }
            if (t.getRight() != null) {
                q.add(t.getRight()); // 큐에 오른쪽 자식 삽입
            }
        }
    }

    public int size(Node<Key> n) {
        if (n == null) {
            return 0;
        }

        return 1 + (size(n.getLeft())) + size(n.getRight());
    }

    public int height(Node<Key> n) {
        if (n == null) {
            return 0;
        }

        return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
    }

    public static <K extends Comparable<K>> boolean isEqual(Node<K> n, Node<K> m) {
        if (n == null || m == null) {
            return n == m;
        }

        if (n.getKey().compareTo(m.getKey()) != 0) {
            return false;
        }

        return isEqual(n.getLeft(), m.getLeft()) && isEqual(n.getRight(), m.getRight());
    }
}