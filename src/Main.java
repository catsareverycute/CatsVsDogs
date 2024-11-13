import java.util.HashMap;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat format;
        format = new DecimalFormat("#.##");
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome. You will be a candidate for the election of 4202. Please input your information before you can start.");
        System.out.println("What is your name?");
        String name = s.nextLine();
        System.out.println("Which party are you representing? (Cat/Dog)");
        String party = s.nextLine().toLowerCase();
        while ((!party.equals("cat")) && (!party.equals("dog"))) {
            System.out.println("Please choose a valid option. (Cat/Dog)");
            party = s.nextLine().toLowerCase();
        }
        if (party.equals("cat")) {
            System.out.println("""
                    Welcome to the Cat Party! We are cuter than dogs and love being indoors.
                     ╱|、
                    (˚ˎ 。7 \s
                     |、˜〵         \s
                     じしˍ,)ノ🐟""");
        } else {
            System.out.println("""
                    Welcome to the Dog Party! We are cuter than cats and love being outdoors.
                    ૮˶• ﻌ •˶ა
                    ./づ~ 🦴""");
        }
        // insert here
        Campaign hi = new Campaign(name, party);
        while (hi.showDay() < 31) {
            String debate = (20 - hi.showDay()) + " days before the Presidential Debate, ";
            if (hi.showDay() == 20) {
                System.out.println("The Presidential Debate is today! Let's go to France!");
                String stop = s.nextLine();
            }
            else if (hi.showDay() > 19) {
                debate = "";
            }
            if (!(hi.showDay() == 20)) {
                System.out.println("\nDay " + hi.showDay() + ": " + debate + (30 - hi.showDay()) + " days before Election Day.");
                System.out.println("Your budget is: " + format.format(hi.showBudget()) + ", what do you want to do today?");
                System.out.println("\n1. Post Promotion (Gain money for other campaigning options)\n2. Hire Workers (For $1,000, hire a social media manager to post for you\n3. Travel to State (For $10,000, campaign at a chosen state)\n4. View Posts (Shows posts YOU made and their statistics)\n5. Sleep (Ends the day)");
                String option = s.nextLine();
                if (option.equals("1")) {
                    System.out.println("coolio");
                }
                if (option.equals("2")) {
                    if (hi.showBudget() < 1000) {
                        System.out.println("haha poor");
                    } else {
                        int max = ((int) hi.showBudget() / 1000);
                        System.out.println("You can hire up to " + max + " workers. Please enter the amount of workers you would like to hire.");
                        int workers = s.nextInt();
                        if (workers > max || workers < 0) {
                            System.out.println("Please enter a number from a range of 1 to " + max);
                        } else {
                            System.out.println("fire");
                        }
                    }
                }
                if (option.equals("5")) {
                    hi.sleep();
                }
            }

        }
    }
}