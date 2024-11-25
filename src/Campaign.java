import java.util.HashMap;
import java.text.DecimalFormat;

public class Campaign {
    DecimalFormat format = new DecimalFormat("#.##");
    private int day = 1;
    private int yourVotes = 0;
    private int oppVotes = 5000000;
    private int workers = 0;
    private int energy = 5;
    private double budget = 0;
    private double voteMultiplier = 1;
    private String party;
    public boolean pass = true;
    public HashMap<String, Integer> catStates = new HashMap<String, Integer>();
    public HashMap<String, Integer> dogStates = new HashMap<String, Integer>();
    public HashMap<String, Integer> swingStates = new HashMap<String, Integer>();

    public Campaign(String party) {
        this.party = party.toLowerCase();
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

    public boolean checkParty() {
        return party.equals("cat") || party.equals("dog");
    }

    public void changeParty(String party) {
        this.party = party.toLowerCase();
    }

    public void starterVotes() {
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

    public String partyConfirmation(String party) {
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

    public String campaignMessage() {
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

    public String checkOption(String option) {
        String message = "";
        if (!((option.equals("1")) || (option.equals("2")) || (option.equals("3")) || (option.equals("4")))){
            message = "Please enter a valid option. (1-4)";
            this.pass = false;
        }
        else if (Integer.parseInt(option) == 1) {
            message = "Please enter what you would like to post.";
        }
        else if (Integer.parseInt(option) == 2) {
            if (budget < 1000) {
                message = "You need " + format.format(1000 - budget) + " more dollars.";
                this.pass = false;
            } else {
                int max = ((int) budget / 1000);
                message = "You can hire up to " + max + " workers. Please enter the amount of workers you would like to hire.";
            }
        }
        else if (Integer.parseInt(option) == 3){
            if (energy < 5) {
                message = "Not enough energy!";
                this.pass = false;
            }
            else if (budget < 10000) {
                message = "You need " + format.format(10000 - budget) + " more dollars.";
                this.pass = false;
            }
            else {
                message = "Which state would you like to go to?\nCat States: Vermont, Maine, Massachusetts, Indiana, Iowa\nDog States: Texas, Montana, Arkansas, Mississippi, Oklahoma\nSwing States: Washington, Delaware, Pennsylvania, Idaho, Wyoming";
            }
        }
        else if (Integer.parseInt(option) == 4) {
            message = "Are you sure you want to go to sleep? (Yes/No)";
        }
        return message;
        
    }

    public boolean checkPass() {
        return pass;
    }

    public boolean invalidOption(Integer option) {
        return ((option > 4) || (option< 0));
    }

    public String campaignOptions(String option, String response)
    {
        String message = "";
        if (option.equals("1")) {
            message = (postPromo(response));
            pass = false;
        }
        else if (option.equals("2")) {
            int max = ((int) budget / 1000);
            if (Integer.parseInt(response) > max || Integer.parseInt(response) < 1) {
                   message = "Please enter a number from a range of 1 to " + max + ".";
            }
            else {
                hireWorkers(Integer.parseInt(response));
                message = "Success. You now have " + energy + " energy left.";
                pass = false;
            }
        }
        else if (option.equals("3")){
            response = response.substring(0,1).toUpperCase() + response.substring(1).toLowerCase();
            if (!((catStates.containsKey(response)) || (dogStates.containsKey(response)) || (swingStates.containsKey(response)))){
                message = "Please enter a valid state.";
                }
            else {
                travelState(response);
                pass = false;
                message = "You visited " + response + "! You gained more voters!";
            }
        }
        else if (option.equals("4")) {
            if (response.toLowerCase().equals("yes")) {
                message = sleep();
                pass = false;
            }
            else if (response.toLowerCase().equals("no")) {
                pass = false;
            }
            else {
                message = "Please enter a valid option. (Yes/No)";
            }
        }
        return message;
    }
    

    public int showDay() {
        return day;
    }

    public int showEnergy() {
        return energy;
    }

    public String postPromo(String post) {
        double multiplier = 500 * day;
        double money = Double.parseDouble(format.format((Math.random()*multiplier) + multiplier));
        budget += money;
        energy--;
        return "You posted: \"" + post + "\" You gained $" + money + ".";
    }

    public void hireWorkers(int workers) {
        this.workers += workers;
        budget -= 1000 * workers;
        voteMultiplier = Math.pow(1.05, this.workers);
        energy--;
    }

    public void travelState(String state) {
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

    public String autoPost() {
        String meow;
        String[] catPosts = {"Cats are so adorable, come support the cats now!","Les chats sont très adorables, venez soutenir les chats maintenant!","猫猫很可爱，快来支持猫猫吧!",
                "Los gatos son muy adorables, ¡apoya a los gatos ya!"};
        String[] dogPosts = {"Dogs are so adorable, come support the dogs now!","Les chiens sont très adorables, venez soutenir les chats maintenant!","狗狗很可爱，快来支持狗狗吧!",
                "Los perros son muy adorables, ¡apoya a los perros ya!"};
        int post = (int) (Math.random() * 4);
        if (party.equals("cat")) {
            meow = catPosts[post];
        }
        else {
            meow = dogPosts[post];
        }
        return meow;
    }

    public String sleep() {
        double multiplier = 50 * day;
        double money = Double.parseDouble(format.format((Math.random()*multiplier)+multiplier));
        String test = "";
        if (workers >= 1) {
            if (day % 3 == 0) {
                budget += money;
                test = "\nA post was made by your workers: \"" + autoPost() + "\" You gained $" + money + ".";
            }
        }
        energy = 5;
        day++;
        oppVotes += (int) (Math.random() * (day * 1000) + 1000);
        return test;
    }

    public int finalVotes(Integer votes) {
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

    public int oppVotes(Integer votes) {
        oppVotes += votes;
        return oppVotes;
    }
}
