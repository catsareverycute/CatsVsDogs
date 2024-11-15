import java.util.HashMap;
import java.text.DecimalFormat;

public class Campaign {
    DecimalFormat format = new DecimalFormat("#.##");
    private int day = 1;
    private int yourVotes = 0;
    private int oppVotes = 0;
    private int workers = 0;
    private int energy = 5;
    private double budget = 9999;
    private double voteMultiplier = 1;
    private String name;
    private String party;
    private HashMap<String, Integer> catStates = new HashMap<String, Integer>();
    private HashMap<String, Integer> dogStates = new HashMap<String, Integer>();
    private HashMap<String, Integer> swingStates = new HashMap<String, Integer>();

    public Campaign(String name, String party) {
        this.name = name;
        this.party = party;
        catStates.put("Vermont", 0);
        catStates.put("Maine", 0);
        catStates.put("Massachusetts", 0);
        catStates.put("Rhode Island", 0);
        catStates.put("New Hampshire", 0);
        dogStates.put("Idaho", 0);
        dogStates.put("Montana", 0);
        dogStates.put("Arkansas", 0);
        dogStates.put("Mississippi", 0);
        dogStates.put("Oklahoma", 0);
        swingStates.put("New York", 0);
        swingStates.put("Delaware", 0);
        swingStates.put("Pennsylvania", 0);
        swingStates.put("Idaho", 0);
        swingStates.put("Wyoming", 0);
        if (party.equals("cat")) {
            for (String i : catStates.keySet()) {
                catStates.replace(i, 10000000);
            }
        } else {
            for (String i : dogStates.keySet()) {
                dogStates.replace(i, 10000000);
            }
        }

    }

    public int showDay() {
        return day;
    }

    public int showEnergy() {
        return energy;
    }

    public double showBudget() {
        return budget;
    }

    public String postPromo(String post) {
        double multiplier = 100 * day;
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
        if (dogStates.containsKey(state)){
                dogStates.replace(state, 10);
        }
        if (catStates.containsKey(state)){
            catStates.replace(state, 10);
        }
        if (swingStates.containsKey(state)){
            swingStates.replace(state, 10);
        }
    }

    public String autoPost() {
        String meow;
        String[] catPosts = {"Cats are so adorable, come support the cats now!","Les chats sont très adorables, venez soutenir les chats maintenant!","猫猫很可爱，快来支持猫猫吧!",
                "Los gatos son muy adorables, ¡apoya a los gatos ya!"};
        String[] dogPosts = {"Dogs are so adorable, come support the dogs now!","Les chiens sont très adorables, venez soutenir les chats maintenant!","狗狗很可爱，快来支持狗狗吧!",
                "Los perros son muy adorables, ¡apoya a los perros ya!"};
        int postTest = (int) (Math.random() * 4);
        if (party.equals("cat")) {
            meow = catPosts[postTest];
        }
        else {
            meow = dogPosts[postTest];
        }
        return meow;
    }

    public String sleep() {
        double multiplier = 50 * day;
        double money = Double.parseDouble(format.format(Math.random()*multiplier));
        String test = "";
        if (workers >= 1) {
            if (day % 3 == 0) {
                budget += money;
                test = "\nA post was made by your workers: \"" + autoPost() + "\" You gained $" + money + ".";
            }
        }
        energy = 5;
        day++;
        return test;
    }
}
