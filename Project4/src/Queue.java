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

    public int queueSize() {
        for (int index = 0; index < Queue.length; index++) {
            if (Queue[index] != null) {
                size++;
            }
        }
        return size;
    }

    public int assignBot() {
        bottom = queueSize() + 1;
        return bottom;
    }

    public Object[] newLength() {
        Object[] newQueue = new Object[Queue.length * 2];
        newQueue = Queue;
        bottom = queueSize() + 1;
        return newQueue;
    }

    public Object delete() {
        if (isEmpty()) {
            return null;
        }
        Object first = Queue[top];
        for (int i = 0; i < Queue.length; i++) {
            Queue[i] = Queue[i + 1];
        }
        queueSize();
        assignBot();
        return first;
    }

    public void insert(Object obj) {

        if (queueSize() == Queue.length) {
            newLength();
        }
        bottom++;
        Queue[bottom - 1] = obj;
        size++;

    }

    public boolean isEmpty() {
        return (queueSize() == 0);
    }

    public String toString() {
        String string = "Index       Value\n";
        for (int i = 0; i < queueSize(); i++) {
            string += i + "     " + Queue[i] + "\n";
        }
        return string;
    }

    public String toStore() {
        String string = "---top---";
        for (int i = top - 1; i >= 0; i--) {
            string += Queue[i] + "\n";
        }
        string += "--bottom--";
        return string;
    }
}
