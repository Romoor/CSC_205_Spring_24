import java.util.Random;
import java.util.Scanner;

public class program4Test {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("1. Test tools");
        System.out.println("2. Play Game");
        int choice = scanner.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.print("Invalid choice. Press 1 for Test tools and 2 for  Play Game: ");
            choice = scanner.nextInt();
        }

        if (choice == 1) {
            testTools();
        } else {
            playGame();

        }
        // lose();
    }

    /**
     * Test with main function code from Program4A
     */
    private static void testTools() {

        Queue inst1 = new Queue();
        Queue inst2 = new Queue();
        // Scanner scanner = new Scanner(System.in);
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
        // scanner.close();
    }

    private static void playGame() {
        // Scanner scanner = new Scanner(System.in);

        /**
         * Create Deck
         */
        /* call heroArray to initialize cards */
        GreekHeroArray heroArray = new GreekHeroArray();
        GreekHero[] cards = heroArray.getCards();
        /* shuffle cards */
        shuffle(cards);
        /* Insert cards into deck */
        Queue deck = new Queue();
        for (int i = 0; i < cards.length; i++) {
            deck.insert(cards[i]);
        }

        /**
         * Deal player1 and player2 hands
         */
        int numCards = 15;
        /* instantiate player1 */
        Queue player1 = new Queue();
        /* deal to player1 */
        for (int i = 0; i < numCards; i++) {
            player1.insert(cards[i]);
        }
        /* Instantiate player2 */
        Queue player2 = new Queue();
        /* Deal to player1 */
        for (int i = numCards; i < numCards * 2; i++) {
            player2.insert(cards[i]);
        }
        Queue center = new Queue();
        int round = 1;
        GreekHero card1 = null;
        GreekHero card2 = null;
        boolean isPlayer1 = true;

        System.out.println("Would you like to play against the computer or another human?");
        System.out.println("1. Computer");
        System.out.println("2. Human");
        int playerChoice = scanner.nextInt();
        while (playerChoice != 1 && playerChoice != 2) {
            System.out.print("Invalid choice. Press 1 for computer and 2 for human: ");
            playerChoice = scanner.nextInt();
        }
        /** Play game */
        while (numCards > 0) {

            System.out.println("\n\n\n------------Round " + round + "------------\n");
            // System.out.println("Player 1 hand: " + player1.toString());
            // System.out.println("Player 2 hand: " + player2.toString());
            System.out.println("Player 1 hand: " + player1.size + " cards");
            System.out.println("Player 2 hand: " + player2.size + " cards\n");
            String property = "";
            if (playerChoice == 2) {
                // vs human
                if (isPlayer1) {
                    System.out.println("Player 1's choice!");
                    card1 = (GreekHero) player1.delete();
                    System.out.println("\nPlayer 1 card:\n" + card1);
                    property = selectProperty(card1);
                    card2 = (GreekHero) player2.delete();
                    System.out.println("\nPlayer 2 card:\n" + card2 + "\n\n");
                } else {
                    System.out.println("Player 2's choice!");
                    card2 = (GreekHero) player2.delete();
                    System.out.println("\nPlayer 2 card:\n" + card2 + "\n\n");
                    property = selectProperty(card2);
                    card1 = (GreekHero) player1.delete();
                    System.out.println("\nPlayer 1 card:\n" + card1);
                }
            } else {
                // vs computer
                if (isPlayer1) {
                    System.out.println("Player 1's choice!");
                    card1 = (GreekHero) player1.delete();
                    System.out.println("\nPlayer 1 card:\n" + card1);
                    property = selectProperty(card1);
                    card2 = (GreekHero) player2.delete();
                    System.out.println("\nPlayer 2 card:\n" + card2 + "\n\n");
                } else {
                    System.out.println("Computer's choice!");
                    card1 = (GreekHero) player1.delete();
                    System.out.println("\nPlayer 1 card:\n" + card1);
                    card2 = (GreekHero) player2.delete();
                    System.out.println("\nPlayer 2 card:\n" + card2 + "\n\n");
                    property = computerProperty(card2);
                    System.out.println("Property: " + property);

                }
            }

            center.insert(card1);
            center.insert(card2);
            // System.out.println("Center: " + center.toString());

            int player1Card = returnValue(card1, property);
            // System.out.println("\n\np1 card value: " + player1Card);
            int player2Card = returnValue(card2, property);
            // System.out.println("\np2 card value: " + player2Card + "\n\n");

            int size = center.size;
            Object object = null;
            System.out.println("\n\n");
            if (player1Card > player2Card) {
                System.out.println("Player 1 wins with " + card1.getName() + "!");
                for (int i = 0; i < size; i++) {
                    object = center.delete();
                    player1.insert(object);
                }

            } else if (player1Card < player2Card) {
                System.out.println("Player 2 wins with " + card2.getName() + "!");
                for (int i = 0; i < size; i++) {
                    object = center.delete();
                    player2.insert(object);
                }

            } else {
                /* In event of Tie */
                System.out.println("Tie between " + card1.getName() + " and " + card2.getName() + "!");
                isPlayer1 = !isPlayer1;

            }
            // System.out.println("\n\nPlayer 1 card:\n" + card1);

            // System.out.println("\n\nPlayer 2 card:\n" + card2 + "\n\n");

            numCards--;
            round++;

            if (round < 15) {
                System.out.print("\nDo you want to go again? type 'Y' if yes, 'N' if no: ");
                String answer = scanner.next();
                while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
                    System.out.print("Invalid choice. Press 'Y' or 'N'");
                    answer = scanner.next();
                }
                if (answer.equalsIgnoreCase("N")) {
                    break;
                }
            }
            isPlayer1 = !isPlayer1;

        }
        System.out.println("\nGame over!");
        if (player1.size > player2.size) {
            System.out.println(
                    "Player 1 wins with a deck size of " + player1.size + " versus Player 2's " + player2.size);
        } else if (player2.size > player1.size) {
            System.out.println(
                    "Player 2 wins with a deck size of " + player2.size + " versus Player 1's " + player1.size);
        } else {

            System.out.println("Tied deck size of " + player1.size);

        }
        // scanner.close();

    }

    private static void shuffle(GreekHero[] cards) {
        Random rand = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            GreekHero temp = cards[index];
            cards[index] = cards[i];
            cards[i] = temp;
        }
    }

    private static String selectProperty(GreekHero card) {

        // select property
        System.out.print("Select your property: ");
        String property = scanner.next();
        // scanner.close();
        return property;
    }

    private static String computerProperty(GreekHero card) {
        String[] alpha = { "a", "b", "c", "d", "e" };
        int random = new Random().nextInt(5);
        String property = alpha[random];
        return property;
    }

    private static int returnValue(GreekHero card, String property) {
        int value = 0;
        if (property.equalsIgnoreCase("A")) {
            value = card.getBravery();
        } else if (property.equalsIgnoreCase("B")) {
            value = card.getWisdom();
        } else if (property.equalsIgnoreCase("C")) {
            value = card.getStrength();
        } else if (property.equalsIgnoreCase("D")) {
            value = card.getFerocity();
        } else if (property.equalsIgnoreCase("E")) {
            value = card.getFearFactor();
        } else {
            System.out.println("not a valid choice");
        }
        return value;
    }

}

class Queue {
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
