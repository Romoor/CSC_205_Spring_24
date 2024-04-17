
package Project6;

import java.util.ArrayList;
import java.util.Scanner;

public class program6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List intList = new List();
        List stringList = new List();

        boolean continueLoop = true;
        while (continueLoop) {
            System.out.print("Do you want to modify (1) intList or (2) stringList? ");
            int choice = scanner.nextInt();
            while (choice != 1 && choice != 2) {
                System.out.println("Invalid selection. Choose (1) intList or (2) stringList: ");
                choice = scanner.nextInt();
            }

            List modList = new List();
            if (choice == 1) {
                modList = intList;
            } else {
                modList = stringList;
            }

            System.out.println("What would you like to do with the list? ");
            System.out.println("1. Create empty list");
            System.out.println("2. Insert item into list");
            System.out.println("3. Insert item at front of list");
            System.out.println("4. Delete item from list");
            System.out.println("5. Retrieve item from position");
            System.out.println("6. Find positions of an item in list");
            System.out.println("7. Get size of list");
            System.out.println("8. Display contents of list");
            System.out.println("9. Quit");

            int modChoice = scanner.nextInt();
            switch (modChoice) {
                case 1:
                    if (choice == 1) {
                        intList = new List();
                    } else {
                        stringList = new List();
                    }
                    break;
                case 2:
                    System.out.print("What would you like to insert? ");
                    Object item = (Object) scanner.next();
                    System.out.print("Where in the list? ");
                    int index = scanner.nextInt();
                    modList.insert(item, index);
                    break;
                case 3:
                    System.out.print("What would you like to insert? ");
                    item = (Object) scanner.next();
                    modList.insertAtFront(item);
                    break;
                case 4:
                    System.out.print("What would you like to delete? ");
                    item = (Object) scanner.next();
                    modList.deleteItem(item);
                    break;
                case 5:
                    System.out.print("What position would you like to retrieve? ");
                    int pos = scanner.nextInt();
                    System.out.println("Item is: " + modList.retrieveItem(pos));
                    break;
                case 6:
                    System.out.println("What item would you like to check? ");
                    item = (Object) scanner.next();
                    System.out.println("Positions are: " + modList.getPositions(item));
                    break;
                case 7:
                    System.out.println("Size is: " + modList.getSize());
                    break;
                case 8:
                    System.out.println(modList.show());
                    break;
                case 9:
                    continueLoop = false;
                    break;

                default:
                    break;
            }
        }
        System.out.println("Goodbye!");
    }
}

class Link {
    public Object data;
    public Link next;

}

class List {
    private Link head;
    private int numMembers;
    // private int position;

    public List() {
        head = null;
        numMembers = 0;
    }

    public void insert(Object item, int index) {
        if (index > numMembers + 1) {
            System.out.println("Invalid index");
        } else {
            Link nLink = new Link();
            nLink.data = item;
            nLink.next = null;
            if (numMembers == 0) {
                head = nLink;
            } else {
                Link prevLink = getLink(index - 1);
                Link nextLink = getLink(index);
                nLink.next = nextLink;
                prevLink.next = nLink;
            }
            numMembers++;
        }
    }

    public void insertAtFront(Object item) {
        Link nLink = new Link();
        nLink.data = item;
        nLink.next = null;
        Link headLink = head;
        nLink.next = headLink;
        head = nLink;
        numMembers++;
    }

    private Link getLink(int index) {
        int count = 0;
        for (Link curLink = head; count < index + 1; curLink = curLink.next) {
            count++;
            if (count == index) {
                return curLink;
            }
        }
        return null;
    }

    public void deleteItem(Object item) {
        if (numMembers == 0) {
            return;
        }
        Link prevLink = head;
        Link curLink = head;
        Link nextLink = curLink.next;
        int length = numMembers;
        for (int i = 0; i < length; i++) {
            System.out.println("currlink: " + curLink.data);
            if (curLink.data.equals(item)) {
                System.out.println("\tcurrlink: " + curLink.data + " equals " + item);
                if (i == 0) {
                    head = nextLink;
                } else {
                    System.out.println("\t\tprevlink: " + prevLink.data);
                    prevLink.next = nextLink;
                    if (nextLink != null) {
                        System.out.println("\t\tnextlink: " + nextLink.data);
                    }
                }
                numMembers--;

            }
            if (nextLink == null) {
                break;
            }
            prevLink = curLink;
            curLink = curLink.next;
            nextLink = curLink.next;
        }

        /*
         * Link nLink = new Link();
         * nLink.data = item;
         * nLink.next = null;
         * int index = 0;
         * for (Link curLink = head; curLink != null; curLink = curLink.next) {
         * System.out.println("currlink: " + curLink.data);
         * index = curLink.getIndex(curLink);
         * System.out.println("curlink value: " + getLink(index).data);
         * System.out.println("currlink: " + curLink.data);
         * if (curLink.data.equals(nLink.data)) {
         * System.out.println("curlink value " + getLink(index).data
         * + " equals 1");
         * Link prevLink = getLink(index - 1);
         * if (index < numMembers) {
         * Link nextLink = curLink.next;
         * if (numMembers == 1) {
         * System.out.println("1 in list");
         * head = null;
         * } else if (prevLink == null) {
         * System.out.println("item was first");
         * System.out.println("next link :" + nextLink.data);
         * head = nextLink;
         * System.out.println("head: " + head.data);
         * System.out.println("currlink: " + curLink.data);
         * 
         * } else {
         * System.out.println("Prev link :" + prevLink.data);
         * System.out.println("next link :" + nextLink.data);
         * System.out.println("assign next to nextLink");
         * prevLink.next = nextLink;
         * }
         * } else {
         * prevLink.next = null;
         * }
         * 
         * numMembers--;
         * }
         * }
         */

    }

    public Object retrieveItem(int pos) {
        return getLink(pos).data;
    }

    public int getSize() {
        return numMembers;
    }

    public int getIndex(Link checLink) {
        int index = 1;
        for (Link curLink = head; curLink != null; curLink = curLink.next) {
            if (checLink.data.equals(curLink.data) && checLink.next.equals(curLink.next)) {
                return index;
            }
            index++;
        }
        return 0;
    }

    public ArrayList<Integer> getPositions(Object item) {
        ArrayList<Integer> posList = new ArrayList<Integer>();
        Link nLink = new Link();
        nLink.data = item;
        nLink.next = null;
        int count = 0;
        for (Link curLink = head; curLink != null; curLink = curLink.next) {
            count++;
            if (curLink.data.equals(nLink.data)) {
                posList.add(count);
            }
        }
        if (posList.size() == 0) {
            System.out.println("Item not found in list");
        }
        return posList;
    }

    public String show() {
        String s = "List contains: [";
        for (Link curLink = head; curLink != null; curLink = curLink.next) {
            s += curLink.data + ",\t";
        }
        s += "]";
        return s;
    }

}