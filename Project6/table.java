package Project6;

public class table {
    private Node root;

    public Sortable search(Sortable item, Node current) {
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