
/**
 * Link
 */
public class Link {

    public Object data;
    public Link next;

}

class Set {
    Link head;

    public Set() {
        head = null;
    }

    public boolean isMember(Object item) {
        if (head == null)
            return false;
        Link currLink = head;
        while (currLink.next != null) {
            if (currLink.data == item) {
                return true;
            }
            currLink = currLink.next;
        }
        return false;
    }

    public Object delete(Object item) {
        if (head == null)
            return null;
        Link prev = null;
        Link curr = head;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        if (prev != null)
            prev.next = null;
        else
            head = null;
        return curr.data;
    }

    public void insert(Object item) {
        if (isMember(item)) {
            return;
        }
        Link nLink = new Link();
        nLink.data = item;
        nLink.next = head;
        head = nLink;
    }

    public String toString() {
        String s = "";
        s += "Queue contents\n";
        s += "-- back --\n";
        Link curr = head;
        while (curr != null) {
            s += curr.data + "\n";
            curr = curr.next;
        }
        s += "-- front --";
        return s;
    }

}
