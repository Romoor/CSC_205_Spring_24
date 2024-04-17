package Homework;

public class table {
    private Node root;

    public void search() {
        Node newNode = new Node();
        newNode.data = search(root);
        root = newNode;
    }

    public Sortable search(Sortable item) {
        int same;
        same = item.compareTo(current.data);
        if (same == 0)
            return current.data;
        else if (same < 0) {
            current = current.left;
            search(item, current);
        } else {
            current = current.right;

            search(item, current);
        }
        return null;
    }

}

interface Sortable {
    public int compareTo(Sortable other);
}

class Node {
    public Sortable data;
    public Node left;
    public Node right;
}