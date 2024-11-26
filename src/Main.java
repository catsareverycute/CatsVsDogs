import java.util.Scanner; // takes in user input to be used in methods

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Beginning of the game
        System.out.println("Welcome. You will be a candidate for the election of 4202. Please input your information before you can start.");
        System.out.println("What is your name?");
        String name = s.nextLine();
        System.out.println("Which party are you representing? (Cat/Dog)");
        String party = s.nextLine().toLowerCase();
        Campaign campaign = new Campaign(party); // creates campaign object to use methods
        while (!campaign.checkParty()) { // checks if party is cat or dog, prompts user to input a valid option if not
            System.out.println("Please choose a valid option. (Cat/Dog)");
            party = s.nextLine().toLowerCase();
            campaign.changeParty(party); // takes in the user's input and changes the party variable stored in campaign
        }
        campaign.starterVotes(); // gives user 1 million votes in each of their party's states
        System.out.println(campaign.partyConfirmation(party)); // prints out message confirming their party
        Debate debate = new Debate (name, party); // creates debate object to use methods
        
        // Main game
        while (campaign.showDay() < 21) { // game will happen within a period of 20 days
            if (campaign.showDay() == 15 ){ // debate starts on day 15
                int response;
                debate.randomName(); // generates a random name for the debateMessage method to use
                for (int i = 0; i < 4; i++) { // loops 4 times, each time will show a different question
                    System.out.println(debate.debateMessage(i)); // shows dialogue, questions, and responses that change each loop
                    boolean checkResponse = false; // checks if response is valid
                    if (i == 3) { // final loop will have the user speak final words instead
                        s.nextLine(); // since i used nextInt for the previous loops this clears errors
                        String finalWords = s.nextLine(); 
                        debate.finalWords(finalWords); // uses the final words the user inputted to judge if they get extra votes
                    }
                    else {
                        while (!checkResponse){ // variable is false so negated for the loop to run
                            try {
                                response = s.nextInt(); // tries to make response an integer
                                if (!debate.checkResponse(response)) { // if the user's response is valid...
                                    debate.debateVotes(response); // ...gives user a certain amount of votes depending on what they chose
                                    debate.oppDebateVotes(); // gives opponent a random amount of votes
                                    checkResponse = true; // ends loop so the for loop can run again
                                }
                                else {
                                    System.out.println("Please enter a valid option. (1-3)"); // makes user enter a valid number response if they entered a number
                                    s.nextLine();
                                }
                            }
                            catch (Exception e) { // catches error of converting string to int
                                System.out.println("Please enter a number. (1-3)"); // if user didn't input a number they are prompted to
                                s.nextLine();
                            }
                        }
                    }
                }
            System.out.println("Bird: That's all for today folks! See you all later on Bird News!");
            campaign.sleep(); // moves on to next day
            }
            else if (campaign.showDay() == 20) { // election day (final day)
                System.out.println("It's Election Day! Let's see how well you did...");
                int additionalVotes = debate.yourVotes(); // takes votes from debate
                int finalVotes = campaign.finalVotes(additionalVotes); // uses votes from debate to be added into final votes being calculating within campaign
                System.out.println("Your votes: " + finalVotes);
                int oppAdditionalVotes = debate.oppVotes(); // takes votes from debate
                int oppFinalVotes = campaign.oppVotes(oppAdditionalVotes); // uses votes from debate to be added into final votes being calculating within campaign
                System.out.println("Opponent's votes: " + oppFinalVotes);
                if (finalVotes > oppFinalVotes) { // compares votes
                    System.out.println("You win! Congrats!");
                }
                else {
                    System.out.println("Better luck next time.");
                }
                campaign.sleep(); // moves on to next day, ending the program
            }
            else {
            System.out.println(campaign.campaignMessage()); // prints a message from campaign depending on certain conditions
            String option = s.nextLine();
            if (campaign.showEnergy() == 0) { // if energy is 0 then makes it so that the only option the user can pick is 4
                while (!option.equals("4")) {
                    System.out.println("Please enter a valid option. (4)");
                    option = s.nextLine();
                }
            }
            System.out.println(campaign.checkOption(option)); // checks option to see if it's valid
            while (campaign.pass) { // uses campaign's pass boolean variable to check if the user can continue
                String response = s.nextLine();
                if (option.equals("2")) { // checks to see if response is an int, if not prompts them to enter a number, then checks if it's in range
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
                    System.out.println(campaign.campaignOptions(option, response)); // all other options go through this and gets checked in the method
                }
            } 
            campaign.pass = true; // so when the loop runs again the user can continue again
        }   
        }
        s.close(); // yay
    }
}