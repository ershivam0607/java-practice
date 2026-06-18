import java.util.*;

class StonePaperScissor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int choice = 0;
        int user_score = 0;
        int comp_score = 0;
        String name = "";
        System.out.println("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Hey " + name + " Let's know the instructions of the game.");
        System.out.println("Press 1 for Stone");
        System.out.println("Press 2 for Paper");
        System.out.println("Press 3 for Scissor");
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            int comp_choice = rand.nextInt(3);
            switch (choice) {
                case 1:
                    if (comp_choice == 0) {
                        System.out.println("You choose Stone.");
                        System.out.println("Computer choose Stone");
                        System.out.println("Draw!!");
                        break;
                    } else if (comp_choice == 1) {
                        System.out.println("You choose Stone.");
                        System.out.println("Computer choose Paper");
                        System.out.println("You Lose!!");
                        comp_score++;
                        break;
                    } else if (comp_choice == 2) {
                        System.out.println("You choose Stone.");
                        System.out.println("Computer choose Scissor");
                        System.out.println("You Won!!");
                        user_score++;
                        break;
                    }
                case 2:
                    if (comp_choice == 0) {
                        System.out.println("You choose Paper.");
                        System.out.println("Computer choose Stone");
                        System.out.println("You Won!!");
                        user_score++;
                        break;
                    } else if (comp_choice == 1) {
                        System.out.println("You choose Paper.");
                        System.out.println("Computer choose Paper");
                        System.out.println("Draw!!");
                        break;
                    } else if (comp_choice == 2) {
                        System.out.println("You choose Paper.");
                        System.out.println("Computer choose Scissor");
                        System.out.println("You Lose!!");
                        comp_score++;
                        break;
                    }
                case 3:
                    if (comp_choice == 0) {
                        System.out.println("You choose Scissor.");
                        System.out.println("Computer choose Stone");
                        System.out.println("You Lose!!");
                        comp_score++;
                        break;
                    } else if (comp_choice == 1) {
                        System.out.println("You choose Scissor.");
                        System.out.println("Computer choose Paper");
                        System.out.println("You Won!!");
                        user_score++;
                        break;
                    } else if (comp_choice == 2) {
                        System.out.println("You choose Scissor.");
                        System.out.println("Computer choose Scissor");
                        System.out.println("Draw!!");
                        break;
                    }
                default:
                    System.out.println("Invalid Choice");
            }
            choice = 0;
            comp_choice = 0;
        }
        System.out.println(name + " Score: " + user_score);
        System.out.println("Computer Score: " + comp_score);
        if (user_score > comp_score) {
            System.out.println(name + " won the game.");
        } else if (user_score == comp_score) {
            System.out.println("Match Draw");
        } else {
            System.out.println("Computer Won, " + name + " lost");
        }
        sc.close();
    }
}