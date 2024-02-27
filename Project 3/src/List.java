public class List {
    private static final int ALLOC = 50;
    String[] list;
    int size;

    public List() {
        list = new String[ALLOC];
        size = 0;
    }

    public String returnString(int index) {
        if (index > 1 && index <= list.length) {
            return list[index];
        }
        return "null";
    }

    public void insert(String item, int index) {
        if (index >= list.length) {
            String[] temp = new String[list.length + ALLOC];
            for (int j = 0; j < index; j++)
                temp[j] = list[j];
            list = temp;
        }
        list[index] = item;
        ++index;
    }

    public int position(String item) {
        for (int i = 0; i < list.length; i++) {
            if (item.equals(list[i])) {
                return i + 1;
            }
        }
        return 0;
    }

    public String toString() {
        String toString = "";
        for (int i = 0; i < list.length; i++) {
            toString += list[i] + " ";
        }
        return toString;
    }

}
