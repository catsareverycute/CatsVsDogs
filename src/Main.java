import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat("#.##");
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
                if (hi.showEnergy() == 0) {
                    System.out.println("\nDay " + hi.showDay() + ": " + debate + (30 - hi.showDay()) + " days before Election Day.");
                    System.out.println("Your budget is: " + format.format(hi.showBudget()) + ", your energy is: " + hi.showEnergy() + ". What do you want to do today?");
                    System.out.println("5. Sleep (Ends the day)");
                    String option = s.nextLine();
                    if (option.equals("5")) {
                        System.out.println(hi.sleep());
                    }
                } else {
                    System.out.println("\nDay " + hi.showDay() + ": " + debate + (30 - hi.showDay()) + " days before Election Day.");
                    System.out.println("Your budget is: " + format.format(hi.showBudget()) + ", your energy is: " + hi.showEnergy() + ". What do you want to do today?");
                    System.out.println("\n1. Post Promotion (Gain money for other campaigning options. [-1 energy])\n2. Hire Workers (For $1,000, hire social media managers to post for you. Money for each of their posts, vote multiplier depending on the number of workers. [-1 energy])\n3. Travel to State (For $10,000, campaign at a chosen state. Main way to gain votes. [-5 energy])\n4. View Posts (Shows posts YOU made and their statistics)\n5. Sleep (Ends the day)");
                    String option = s.nextLine();
                    if (option.equals("1")) {
                        System.out.println("Please enter what you would like to post.");
                        String post = s.nextLine();
                        System.out.println(hi.postPromo(post));
                    }
                    if (option.equals("2")) {
                        int workers;
                        if (hi.showBudget() < 1000) {
                            System.out.println("haha poor");
                        } else {
                            int max = ((int) hi.showBudget() / 1000);
                            System.out.println("You can hire up to " + max + " workers. Please enter the amount of workers you would like to hire.");
                            workers = s.nextInt();
                            while (workers > max || workers < 1) {
                                System.out.println("Please enter a number from a range of 1 to " + max + ".");
                                workers = s.nextInt();
                            }
                            hi.hireWorkers(workers);
                            System.out.println("Success. You now have " + hi.showEnergy() + " energy left.");
                        }
                    }
                    if (option.equals("5")) {
                        System.out.println(hi.sleep());
                    }
                }
            }
        }
    }
}