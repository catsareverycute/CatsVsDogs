import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Beginning of the game
        System.out.println("Welcome. You will be a candidate for the election of 4202. Please input your information before you can start.");
        System.out.println("What is your name?");
        String name = s.nextLine();
        System.out.println("Which party are you representing? (Cat/Dog)");
        String party = s.nextLine().toLowerCase();
        Campaign campaign = new Campaign(party);
        while (!campaign.checkParty()) {
            System.out.println("Please choose a valid option. (Cat/Dog)");
            party = s.nextLine().toLowerCase();
            campaign.changeParty(party);
        }
        campaign.starterVotes();
        System.out.println(campaign.partyConfirmation(party));
        Debate debate = new Debate (name, party);

        while (campaign.showDay() < 21) {
            if (campaign.showDay() == 15 ){
                int response;
                debate.randomName();
            for (int i = 0; i < 4; i++) {
                System.out.println(debate.debateMessage(i));
                boolean checkResponse = false;
                if (i == 3) {
                    s.nextLine();
                    String finalWords = s.nextLine();
                    debate.finalWords(finalWords);
                }
                else {
                while (!checkResponse){
                try {
                    response = s.nextInt();
                    if (!debate.checkResponse(response)) {
                        debate.debateVotes(response);
                        debate.oppDebateVotes();
                        checkResponse = true;
                    }
                    else {
                        System.out.println("Please enter a valid option. (1-3)");
                        s.nextLine();
                    }
                }
                catch (Exception e) {
                    System.out.println("Please enter a number. (1-3)");
                    s.nextLine();
                }
            }
                }
            }
            System.out.println("Bird: That's all for today folks! See you all later on Bird News!");
            campaign.sleep();
            }
            else if (campaign.showDay() == 20) {
                System.out.println("It's Election Day! Let's see how well you did...");
                int additionalVotes = debate.yourVotes();
                int finalVotes = campaign.finalVotes(additionalVotes);
                System.out.println("Your votes: " + finalVotes);
                int oppAdditionalVotes = debate.oppVotes();
                int oppFinalVotes = campaign.oppVotes(oppAdditionalVotes);
                System.out.println("Opponent's votes: " + oppFinalVotes);
            if (finalVotes > oppFinalVotes) {
                System.out.println("You win! Congrats!");
            }
            else {
                System.out.println("Better luck next time.");
            }
            campaign.sleep();
            }
            else {
            System.out.println(campaign.campaignMessage());
            String option = s.nextLine();
            if (campaign.showEnergy() == 0) {
                while (!option.equals("4")) {
                    System.out.println("Please enter a valid option. (4)");
                    option = s.nextLine();
                }
            }
            System.out.println(campaign.checkOption(option));
            while (campaign.pass) {
                String response = s.nextLine();
                if (option.equals("2")) {
                    try {
                        Integer.parseInt(response);
                        System.out.println(campaign.campaignOptions(option,response));
                    }
                    catch (Exception e) {
                        System.out.println("Please enter a number.");
                        continue;
                    }
                }
                else {
                    System.out.println(campaign.campaignOptions(option, response));
                }
            } 
            campaign.pass = true;
        }
        }
        s.close(); 
    }
}