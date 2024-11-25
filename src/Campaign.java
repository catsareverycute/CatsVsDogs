import java.util.HashMap;
import java.text.DecimalFormat;

public class Campaign {
    DecimalFormat format = new DecimalFormat("#.##"); // formats money
    private int day = 1; // game starts day 1 and will increment
    private int yourVotes = 0; // your votes at the beginning (it'll change)
    private int oppVotes = 5000000; // your opponent's votes at the beginning (it'll change)
    private int workers = 0; // amount of workers you have
    private int energy = 5; // amount of energy you have each day
    private double budget = 0; // your money
    private double voteMultiplier = 1; // vote multiplier
    private String party; // your party
    public boolean pass = true; // variable uses to determine if user can continue in options
    public HashMap<String, Integer> catStates = new HashMap<String, Integer>(); // hash map for cat states to store state votes
    public HashMap<String, Integer> dogStates = new HashMap<String, Integer>(); // hash map for dog states to store state votes
    public HashMap<String, Integer> swingStates = new HashMap<String, Integer>(); // hash map for swing states to store state votes

    public Campaign(String party) { // creates campaign object using party input to store party into a variable
        this.party = party.toLowerCase();
        // sets all states and values in their respective hashmap 
        catStates.put("Vermont", 0);
        catStates.put("Maine", 0);
        catStates.put("Massachusetts", 0);
        catStates.put("Indiana", 0);
        catStates.put("Iowa", 0);
        dogStates.put("Texas", 0);
        dogStates.put("Montana", 0);
        dogStates.put("Arkansas", 0);
        dogStates.put("Mississippi", 0);
        dogStates.put("Oklahoma", 0);
        swingStates.put("Washington", 0);
        swingStates.put("Delaware", 0);
        swingStates.put("Pennsylvania", 0);
        swingStates.put("Idaho", 0);
        swingStates.put("Wyoming", 0);
    }

    public boolean checkParty() { // checks to see if party is valid 
        return party.equals("cat") || party.equals("dog");
    }

    public void changeParty(String party) { // changes party based on new user input
        this.party = party.toLowerCase();
    }

    public void starterVotes() { // gives user starter votes by changing votes in each state of their party
        if (party.equals("cat")) {
            for (String i : catStates.keySet()) {
                catStates.replace(i, 1000000);
            }
        } else {
            for (String i : dogStates.keySet()) {
                dogStates.replace(i, 1000000);
            }
        }
    }

    public String partyConfirmation(String party) { // returns confirmation message based on party
        if (party.equals("cat")) {
            return ("""
                    Welcome to the Cat Party! We are cuter than dogs and love being indoors.
                     ╱|、
                    (˚ˎ 。7 \s
                     |、˜〵         \s
                     じしˍ,)ノ🐟""");
        } else {
            return ("""
                    Welcome to the Dog Party! We are cuter than cats and love being outdoors.
                    ૮˶• ﻌ •˶ა
                    ./づ~ 🦴""");
        }
    }

    public String campaignMessage() { // returns campaign message with options depending on day and energy
        String message = "";
        String debate = (15 - day) + " days before the Presidential Debate, ";
        if (day > 15) {
            debate = "";
        }
        if (energy == 0) {
            message = "\nDay " + day + ": " + debate + " days before Election Day.\nYour budget is: " + format.format(budget) + ", your energy is: " + energy + ". What do you want to do today?\n\n4. Sleep (Ends the day.)";
        } else {
            message = "\nDay " + day + ": " + debate + (20 - day) + " days before Election Day.\nYour budget is: " + format.format(budget) + ", your energy is: " + energy + ". What do you want to do today?\n\n1. Post Promotion (Gain money for other campaigning options. [-1 energy])\n2. Hire Workers (For $1,000, hire social media managers to post for you. Money for each of their posts, vote multiplier depending on the number of workers. [-1 energy])\n3. Travel to State (For $10,000, campaign at a chosen state. Main way to gain votes. [-5 energy])\n4. Sleep (Ends the day.)";
        }
    return message;
    }

    public String checkOption(String option) { // checks if user gave a 1, 2, 3, or 4 and if they meet certain requirements
        String message = "";
        if (!((option.equals("1")) || (option.equals("2")) || (option.equals("3")) || (option.equals("4")))){
            message = "Please enter a valid option. (1-4)";
            this.pass = false; // doesn't let the user pass until they give a valid option (1-4)
        }
        else if (Integer.parseInt(option) == 1) {
            message = "Please enter what you would like to post."; // user can type anything to post after
        }
        else if (Integer.parseInt(option) == 2) {
            if (budget < 1000) {
                message = "You need " + format.format(1000 - budget) + " more dollars.";
                this.pass = false; // doesn't let user pass due to not having enough money
            } else { // tells user how much workers they can buy
                int max = ((int) budget / 1000); 
                message = "You can hire up to " + max + " workers. Please enter the amount of workers you would like to hire.";
            }
        }
        else if (Integer.parseInt(option) == 3){ 
            if (energy < 5) { // if user doesn't have enough energy they can't pass
                message = "Not enough energy!";
                this.pass = false;
            }
            else if (budget < 10000) { // if user doesn't have enough money they can't pass
                message = "You need " + format.format(10000 - budget) + " more dollars.";
                this.pass = false;
            }
            else { // prompts user to enter state
                message = "Which state would you like to go to?\nCat States: Vermont, Maine, Massachusetts, Indiana, Iowa\nDog States: Texas, Montana, Arkansas, Mississippi, Oklahoma\nSwing States: Washington, Delaware, Pennsylvania, Idaho, Wyoming";
            }
        }
        else if (Integer.parseInt(option) == 4) {
            message = "Are you sure you want to go to sleep? (Yes/No)"; // user can choose to sleep or not after
        }
        return message;
        
    }

    public boolean checkPass() { // sees if pass is false (can't pass) or true (can pass)
        return pass;
    }

    public String campaignOptions(String option, String response) // if user can pass takes in user response to check if it works and does methods for each option then
    {
        String message = "";
        if (option.equals("1")) {
            message = (postPromo(response));
            pass = false; // ends loop of giving valid input
        }
        else if (option.equals("2")) {
            int max = ((int) budget / 1000);
            if (Integer.parseInt(response) > max || Integer.parseInt(response) < 1) {
                   message = "Please enter a number from a range of 1 to " + max + ".";
            }
            else {
                hireWorkers(Integer.parseInt(response));
                message = "Success. You now have " + energy + " energy left.";
                pass = false; // ends loop of giving valid input
            }
        }
        else if (option.equals("3")){
            // edits response to match the key of the hashmaps
            response = response.substring(0,1).toUpperCase() + response.substring(1).toLowerCase();
            if (!((catStates.containsKey(response)) || (dogStates.containsKey(response)) || (swingStates.containsKey(response)))){
                message = "Please enter a valid state.";
                }
            else {
                travelState(response);
                pass = false; // ends loop of giving valid input
                message = "You visited " + response + "! You gained more voters!";
            }
        }
        else if (option.equals("4")) {
            if (response.toLowerCase().equals("yes")) {
                message = sleep(); // goes to next day
                pass = false; // ends loop of giving valid input
            }
            else if (response.toLowerCase().equals("no")) {
                pass = false; // ends loop of giving valid input
            }
            else {
                message = "Please enter a valid option. (Yes/No)";
            }
        }
        return message;
    }
    

    public int showDay() { // returns current day
        return day;
    }

    public int showEnergy() { // returns current energy
        return energy;
    }

    public String postPromo(String post) { // gives user money based on a range and adds it to the budget while decreasing energy
        double multiplier = 500 * day;
        double money = Double.parseDouble(format.format((Math.random()*multiplier) + multiplier));
        budget += money;
        energy--;
        return "You posted: \"" + post + "\" You gained $" + money + ".";
    }

    public void hireWorkers(int workers) { // updates total amount of workers, removing money but adding a vote multiplier, decreasing energy 
        this.workers += workers;
        budget -= 1000 * workers;
        voteMultiplier = Math.pow(1.05, this.workers);
        energy--;
    }

    public void travelState(String state) { // decreases budget while increasing votes in a given state depending on party
        budget -= 10000;
        int gainedOwnVotes = ((int) (Math.random() * 10000) + 5000);
        int gainedOppVotes = ((int) (Math.random() * 10000) + 1000);
        int gainedSwingVotes = ((int) (Math.random() * 10000) + 10000);
        if (party.equals("dog")) {
            if (dogStates.containsKey(state)) {
                dogStates.replace(state, dogStates.get(state) + (gainedOwnVotes));
            }
            else if (catStates.containsKey(state)) {
                catStates.replace(state, catStates.get(state) + gainedOppVotes);
        }
        }
        if (party.equals("cat")) {
            if (dogStates.containsKey(state)) {
                dogStates.replace(state, dogStates.get(state) + gainedOppVotes);
            }
            else if (catStates.containsKey(state)) {
                catStates.replace(state, catStates.get(state) + gainedOwnVotes);
            }
        }
        if (swingStates.containsKey(state)) {
            swingStates.replace(state, swingStates.get(state) + gainedSwingVotes);
        }
        energy -= 5;
    }

    public String autoPost() { // returns a random string if user has a worker each three days (see sleep method)
        String posts;
        String[] catPosts = {"Cats are so adorable, come support the cats now!","Les chats sont très adorables, venez soutenir les chats maintenant!","猫猫很可爱，快来支持猫猫吧!",
                "Los gatos son muy adorables, ¡apoya a los gatos ya!"};
        String[] dogPosts = {"Dogs are so adorable, come support the dogs now!","Les chiens sont très adorables, venez soutenir les chats maintenant!","狗狗很可爱，快来支持狗狗吧!",
                "Los perros son muy adorables, ¡apoya a los perros ya!"};
        int post = (int) (Math.random() * 4);
        if (party.equals("cat")) {
            posts = catPosts[post];
        }
        else {
            posts = dogPosts[post];
        }
        return posts;
    }

    public String sleep() {
        double multiplier = 50 * day;
        double money = Double.parseDouble(format.format((Math.random()*multiplier)+multiplier));
        String test = "";
        if (workers >= 1) { // must have at least one worker
            if (day % 3 == 0) { // every three days the autoPost method happens and money is gained
                budget += money;
                test = "\nA post was made by your workers: \"" + autoPost() + "\" You gained $" + money + ".";
            }
        }
        energy = 5; // resets energy back to 5
        day++; // goes to next day
        oppVotes += (int) (Math.random() * (day * 10000) + 1000); // gives opponent some votes
        return test;
    }

    public int finalVotes(Integer votes) { // calculates final votes by going through each hash map then adding debate votes
        for (int i : catStates.values()) {
            yourVotes += i;
        }
        for (int i : dogStates.values()) {
            yourVotes += i;
        }
        for (int i : swingStates.values()) {
            yourVotes += i;
        }
        yourVotes += votes;
        yourVotes = (int) (yourVotes * voteMultiplier);
        return yourVotes;
    }

    public int oppVotes(Integer votes) { // calculates final votes by adding debate votes
        oppVotes += votes;
        return oppVotes;
    }
}
