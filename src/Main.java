import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
            System.out.println("Welcome to the Cat Party! We are cuter than dogs and love being indoors.\n" +
                    " ╱|、\n" +
                    "(˚ˎ 。7  \n" +
                    " |、˜〵          \n" +
                    " じしˍ,)ノ");
        }
        else {
            System.out.println("Welcome to the Dog Party! We are cuter than cats and love being outdoors.\n" +
                    "૮˶• ﻌ •˶ა\n" +
                    "./づ~ \uD83E\uDDB4");
        }
        // insert here
        Campaign hi = new Campaign(name, party);
        System.out.println("Day " + hi.showDay() + ": " + (16 - hi.showDay()) + " days before the debate, " + (31 - hi.showDay()) + " days before Election Day.");
    }
}