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
        Object[] newQueue = new Object[Queue.length * 2];
        for (int i = 0; i < size; i++) {
            newQueue[i] = Queue[top + i];
        }
        Queue = newQueue;
    }

    public Object delete() {
        size--;
        if (isEmpty()) {
            return null;
        }
        Object first = Queue[top];
        for (int i = 0; i < size; i++) {
            Queue[i] = Queue[i + 1];
        }
        top++;
        return first;
    }

    public void insert(Object obj) {
        size++;

        if (size == Queue.length) {
            newLength();
        }
        Queue[bottom] = obj;
        bottom++;

    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public String toString() {
        String string = "";
        string += "Index       Value\n";
        for (int i = 0; i < size; i++) {
            string += " " + i + "        " + Queue[i] + "\n";
        }
        return string;
    }

    public String toStore() {
        String string = "";
        string += "Index       Value\n";
        for (int i = 0; i < Queue.length; i++) {
            Object value = 0;
            if (Queue[i] == null)
                value = "null";
            else
                value = Queue[i];
            System.out.println(value);
            string += " " + i + "         " + value + "\n";
        }
        return string;
    }
}
