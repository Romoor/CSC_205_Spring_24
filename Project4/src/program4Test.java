import java.util.Random;
import java.util.Scanner;

public class program4Test {

    public static void main(String[] args) {
        // call testTools automatically
        // testTools();

        // then call playGame automatically
        playGame();

    }

    /**
     * Test with main function code from Program4A
     */
    private static void testTools() {

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

    private static void playGame() {
        Scanner scanner = new Scanner(System.in);

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

        /** Play game */
        while (numCards > 0) {

            System.out.println("\n\n\n------------Round " + round + "------------\n");
            // System.out.println("Player 1 hand: " + player1.toString());
            // System.out.println("Player 2 hand: " + player2.toString());
            String property = "";
            if (isPlayer1) {
                System.out.println("Player 1's choice!");
                card1 = (GreekHero) player1.delete();
                System.out.println("\nPlayer 1 card:\n\t" + card1);
                property = selectProperty(card1);
                card2 = (GreekHero) player2.delete();
                System.out.println("\nPlayer 2 card:\n" + card2 + "\n\n");
            } else {
                System.out.println("Player 2's choice!");
                card2 = (GreekHero) player2.delete();
                System.out.println("\nPlayer 2 card:\n\t" + card2 + "\n\n");
                property = selectProperty(card2);
                card1 = (GreekHero) player1.delete();
                System.out.println("\nPlayer 1 card:\n" + card1);
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
                    // System.out.println("center size: " + size);
                    // System.out.println("object:" + object);
                    object = center.delete();
                    // System.out.println("object:" + object);
                    player1.insert(object);
                    // System.out.println();

                }
                // System.out.println("Player 1 hand: " + player1.toString());
                // System.out.println("Player 2 hand: " + player2.toString());
                // System.out.println("Center hand: " + center.toString());

            } else if (player1Card < player2Card) {
                System.out.println("Player 2 wins with " + card2.getName() + "!");
                for (int i = 0; i < size; i++) {
                    // System.out.println("center size: " + size);
                    // System.out.println("object:" + object);
                    object = center.delete();
                    // System.out.println("object:" + object);
                    player2.insert(object);
                    // System.out.println();
                }
                // System.out.println("\n\nPlayer 1 hand: " + player1.toString());
                // System.out.println("Player 2 hand: " + player2.toString());
                // System.out.println("Center hand: " + center.toString());
            } else {
                /* In event of Tie */
                System.out.println("Tie between " + card1.getName() + " and " + card2.getName() + "!");
                // System.out.println("Player 1 hand: " + player1.toString());
                // System.out.println("Player 2 hand: " + player2.toString());
                // System.out.println("Center hand: " + center.toString());
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
                isPlayer1 = !isPlayer1;
            }
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
        Scanner scanner = new Scanner(System.in);

        // select property
        System.out.print("Select your property: ");
        String property = scanner.next();
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
