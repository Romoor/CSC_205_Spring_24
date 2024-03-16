import java.util.Scanner;

public class program4Test {
    public static void main(String[] args) {
        Queue inst1 = new Queue();
        Queue inst2 = new Queue();
        Scanner scanner = new Scanner(System.in);
        int queueChoice = 0;
        do {
            System.out.println("Queue Selection");
            System.out.print("Which queue? Press 1 for queue1 and 2 for queue2, other to quit: ");
            queueChoice = scanner.nextInt();
            Queue queue = new Queue();
            // do {

            switch (queueChoice) {
                case 1:
                    queue = inst1;
                    break;
                case 2:
                    queue = inst2;
                    break;
                default:
                    // System.out.println("Please select 1 or 2");
                    // System.out.print("Which queue? Press 1 for queue1 and 2 for queue2: ");
                    // queueChoice = scanner.nextInt();
                    break;
            }
            // } while (queueChoice != 1 || queueChoice != 2);

            System.out.println("Menu");
            System.out.println("1. Create empty Queue");
            System.out.println("2. Delete an Object from the queue");
            System.out.println("3. Insert an name (no  spaces) into the queue");
            System.out.println("4. Check if Queue is empty");
            System.out.println("5. Display contents of queue");
            System.out.println("6. Diplay whole queue");
            System.out.print("\nWhat would you like to do with the Queue? Select a number: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    queue = new Queue();
                    System.out.println("New empty queue has been created");
                    System.out.println("Current queue: " + queue.toString());
                    break;
                case 2:
                    System.out.println(queue.delete() + " has been deleted");
                    System.out.println("Current queue: " + queue.toString());
                    break;
                case 3:
                    System.out.println("What name (no spaces) would you like to add? ");
                    String obj = scanner.next();
                    queue.insert(obj);
                    System.out.println("Current queue: " + queue.toString());

                    break;
                case 4:
                    if (queue.isEmpty()) {
                        System.out.println("Yes the queue is empty");
                    } else {
                        System.out.println("The queue is not empty");
                    }
                    break;
                case 5:
                    queue.toString();
                    break;
                case 6:
                    queue.toStore();
                    break;
                default:
                    break;
            }
        } while (queueChoice != 1 || queueChoice != 2);
    }
}
