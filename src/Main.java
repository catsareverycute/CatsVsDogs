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
        Campaign campaign = new Campaign(name, party);
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
        // Main game
        /* Debate test = new Debate(name, party);
        while (campaign.showDay() < 31) {
            String debate = (20 - campaign.showDay()) + " days before the Presidential Debate, ";
            if (campaign.showDay() == 20) {
                test.randomName();
                System.out.println("The Presidential Debate is today! Let's go to the Bird News Station!");
                System.out.println("Welcome to this year's Presidential Debate! I'm your host, Bird, and I'll be asking these candidates some questions.");
                System.out.println("Our candidates are " + test.showName() + " and " + test.showOppName() + "!");
                System.out.println("Now, " + test.showName() + ". What are your plans regarding staying indoors for this nation?");
                System.out.println("Choose a response: \n1. I will allow our citizens to stay inside for as long as they want!\n2. Citizens will have to go outside each day to be healthy and have fun!\n3. I wouldn't stay inside for a long time, but sometimes, you don't have to go outside everyday.\n4. Um...");
                int response = s.nextInt();
                while ((response > 4) || (response < 0)) {
                    System.out.println("Please enter an option from 1-4.");
                    response = s.nextInt();
                }
                test.debateVotes(response);
                test.oppDebateVotes();
                System.out.println("Alright! How about you, " + test.showOppName() + "?");
                System.out.println(test.showOppName() + ": " + test.oppRandomLine());
                System.out.println("Wow! Tell me, " + campaign.showName() + ". How will you accommodate for the other party?");
                System.out.println("Choose a response: \n1. Everyone gets any snacks they want!\n2. Everyone can sleep when they want!\n3. Everyone gets all the luxuries!\n4. Uhh...");
                response = s.nextInt();
                while ((response > 4) || (response < 0)) {
                    System.out.println("Please enter an option from 1-4.");
                    response = s.nextInt();
                }
                test.debateVotes(response);
                test.oppDebateVotes();
                System.out.println("And now, " + test.showOppName() + ", what do you have to say?");
                System.out.println(test.showOppName() + ": " + test.oppRandomLine());
                System.out.println("Very well. Any final words?");
                String finalWords = s.nextLine();
                test.finalWords(finalWords);
                System.out.println("That's all for today folks! Good night!");
                campaign.sleep();
            }
            else if (campaign.showDay() > 19) {
                debate = "";
            }
            if ((campaign.showDay() != 20) && (campaign.showDay() != 30)) {
                if (campaign.showEnergy() == 0) {
                    System.out.println("\nDay " + campaign.showDay() + ": " + debate + (30 - campaign.showDay()) + " days before Election Day.");
                    System.out.println("Your budget is: " + format.format(campaign.showBudget()) + ", your energy is: " + campaign.showEnergy() + ". What do you want to do today?");
                    System.out.println("4. Sleep (Ends the day)");
                    String option = s.nextLine();
                    if (option.equals("4")) {
                        System.out.println(campaign.sleep());
                    }
                } else {
                    System.out.println("\nDay " + campaign.showDay() + ": " + debate + (30 - campaign.showDay()) + " days before Election Day.");
                    System.out.println("Your budget is: " + format.format(campaign.showBudget()) + ", your energy is: " + campaign.showEnergy() + ". What do you want to do today?");
                    System.out.println("\n1. Post Promotion (Gain money for other campaigning options. [-1 energy])\n2. Hire Workers (For $1,000, hire social media managers to post for you. Money for each of their posts, vote multiplier depending on the number of workers. [-1 energy])\n3. Travel to State (For $10,000, campaign at a chosen state. Main way to gain votes. [-5 energy])\n4. Sleep (Ends the day)");
                    String option = s.nextLine();
                    if (option.equals("1")) {
                        System.out.println("Please enter what you would like to post.");
                        String post = s.nextLine();
                        System.out.println(campaign.postPromo(post));
                    }
                    if (option.equals("2")) {
                        int workers;
                        if (campaign.showBudget() < 1000) {
                            System.out.println("You need " + format.format(1000 - campaign.showBudget()) + " more dollars.");
                        } else {
                            int max = ((int) campaign.showBudget() / 1000);
                            System.out.println("You can hire up to " + max + " workers. Please enter the amount of workers you would like to hire.");
                            workers = s.nextInt();
                            while (workers > max || workers < 1) {
                                System.out.println("Please enter a number from a range of 1 to " + max + ".");
                                workers = s.nextInt();
                            }
                            campaign.hireWorkers(workers);
                            System.out.println("Success. You now have " + campaign.showEnergy() + " energy left.");
                        }
                    }
                    if (option.equals("3")){
                        if (campaign.showBudget() < 10000) {
                            System.out.println("You need " + format.format(10000 - campaign.showBudget()) + " more dollars.");
                        }
                        else if (campaign.showEnergy() < 5) {
                            System.out.println("Not enough energy!");
                        }
                        else {
                            System.out.println("Which state would you like to go to?\nCat States: Vermont, Maine, Massachusetts, Rhode Island, New Hampshire");
                            String state = s.nextLine();
                            while ((!campaign.catStates.containsKey(state)) || (!campaign.dogStates.containsKey(state)) || (!campaign.swingStates.containsKey(state))){
                                System.out.println("Please enter a valid state.");
                                state = s.nextLine();
                            }
                            campaign.travelState(state);
                        }
                    }
                    if (option.equals("4")) {
                        System.out.println(campaign.sleep());
                    }
                }
            }
            if (campaign.showDay() == 30) {
                System.out.println("It's Election Day! Let's see how well you did...");
                int addVotes = test.yourVotes();
                int finalVotes = campaign.finalVotes(addVotes);
                System.out.println("Your votes: " + finalVotes);
                int oppAddVotes = test.oppVotes();
                int oppFinalVotes = campaign.oppVotes(oppAddVotes);
                System.out.println("Opponent's votes: " + oppFinalVotes);
                if (finalVotes > oppAddVotes) {
                    System.out.println("You win! Congrats!");
                }
                else {
                    System.out.println("Better luck next time.");
                }
                campaign.sleep();
            }
        } 
        s.close(); */
    }
}