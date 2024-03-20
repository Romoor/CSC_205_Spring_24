public class Queue {
    final int ALLOC = 16;
    Object[] Queue;
    int top; // front index
    int bottom;
    int size;

    public Queue() {
        Queue = new Object[ALLOC];
        top = 0;
        bottom = 0;
        size = 0;
    }

    public void newLength() {
        // System.out.println("expand called");
        Object[] newQueue = new Object[Queue.length * 2];
        // System.out.println("size: " + size);
        for (int i = 0; i < bottom; i++) {
            newQueue[i] = Queue[i];
            // System.out.println("queue[" + i + "]:" + newQueue[i]);
        }
        Queue = newQueue;
    }

    public Object delete() {
        // System.out.println("size: " + size);
        if (isEmpty()) {
            return null;
        }
        // System.out.println("top: " + top);
        Object first = Queue[0];
        // System.out.println("Delete: " + first);
        size--;

        for (int i = 0; i < size; i++) {
            Queue[i] = Queue[i + 1];
        }

        // System.out.println("First: " + Queue[0]);
        bottom--;
        // System.out.println("Last: " + Queue[bottom]);

        return first;
    }

    public void insert(Object obj) {
        size++;

        if (bottom >= Queue.length) {
            newLength();
        }

        Queue[bottom] = obj;
        // System.out.println("Insert: " + obj);
        // System.out.println("First: " + Queue[top]);
        // System.out.println("Last: " + Queue[bottom]);
        bottom++;

    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public String toString() {
        // System.out.println("Tostring size: " + size);
        String string = "";
        string += "Index       Value\n";
        for (int i = 0; i < size; i++) {
            string += " " + (i + 1) + "             " + Queue[i] + "\n";
        }
        return string;
    }

    public String toStore() {
        String string = "";
        // System.out.println("ToSTore size: " + Queue.length);

        string += "Index       Value\n";
        for (int i = 0; i < Queue.length; i++) {
            Object value = 0;
            if (Queue[i] == null)
                value = "null";
            else
                value = Queue[i];
            // System.out.println(value);
            string += " " + i + "             " + value + "\n";
        }
        return string;
    }
}
