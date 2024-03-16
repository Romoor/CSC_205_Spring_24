public class Queue {
    static final int ALLOC = 16;
    Object[] Queue;
    int top; // front index
    int bottom;

    public Queue() {
        Queue = new Queue[ALLOC];
        top = 0;
        bottom = 0;
    }

    public int queueSize() {
        int size = 0;
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
        assignBot();
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

    public void insert(String obj) {
        Object object = obj;
        System.out.println("current size" + queueSize());
        System.out.println("length" + Queue.length);
        if (queueSize() == Queue.length) {
            newLength();
            System.out.println("new length created");
        }
        System.out.println(bottom);
        Queue[bottom] = object;
        System.out.println(Queue[bottom]);
        queueSize();
        System.out.println(queueSize());
        assignBot();
        System.out.println(assignBot());
    }

    public boolean isEmpty() {
        return (queueSize() == 0);
    }

    public String toString() {
        String string = "Index       Value";
        for (int i = 0; i < queueSize(); i++) {
            string += i + "     " + Queue[i];
        }
        return string;
    }

    public String toStore() {
        String string = "Index       Value";
        for (int i = 0; i < Queue.length; i++) {
            string += i + "     " + Queue[i];
        }
        return string;
    }
}
