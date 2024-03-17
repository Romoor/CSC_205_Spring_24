import java.util.Scanner;

public class program4Test {
    public static void main(String[] args) {
        Queue inst1 = new Queue();
        Queue inst2 = new Queue();
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = false;
        do {
            System.out.println("Queue Selection");
            System.out.print("Which queue? Press 1 for queue1 and 2 for queue2: ");
            int queueChoice = scanner.nextInt();
            while (queueChoice != 1 && queueChoice != 2) {
                System.out.print("Invalid choice. Press 1 for queue1 and 2 for queue2: ");
                queueChoice = scanner.nextInt();
            }

            Queue queue = new Queue();

            switch (queueChoice) {
                case 1:
                    queue = inst1;
                    break;
                case 2:
                    queue = inst2;
                    break;
                default:
                    break;
            }

            System.out.println("Menu");
            System.out.println("1. Delete an Object from the queue");
            System.out.println("2. Insert an name into the queue");
            System.out.println("3. Check if Queue is empty");
            System.out.println("4. Display contents of queue");
            System.out.println("5. Diplay whole queue");
            System.out.print("\nWhat would you like to do with the Queue? Select a number: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(queue.delete() + " has been deleted");
                    System.out.println("Current queue: \n" + queue.toString());
                    break;
                case 2:
                    System.out.println("What name (no spaces) would you like to add? ");
                    queue.insert(scanner.next());
                    System.out.println("insert ran");
                    System.out.println("Current queue: \n" + queue.toString());

                    break;
                case 3:
                    if (queue.isEmpty()) {
                        System.out.println("Yes the queue is empty");
                    } else {
                        System.out.println("The queue is not empty");
                    }
                    break;
                case 4:
                    System.out.println(queue.toString());
                    break;
                case 5:
                    System.out.println(queue.toStore());
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
                    break;
            }
            System.out.println("Do you want to go again? type 'Y' if yes, 'N' if no: ");
            String answer = scanner.next();
            while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
                System.out.print("Invalid choice. Press 'Y' or 'N'");
                answer = scanner.next();
            }
            continueLoop = (answer.equalsIgnoreCase("Y"));

        } while (continueLoop);
        System.out.println("Goodbye!");
        scanner.close();
    }

}
