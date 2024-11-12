import java.util.HashMap;

public class Campaign {
private int day = 1;
private int yourVotes = 0;
private int oppVotes = 0;
private double budget = 0;
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
        swingStates.put("Wyoming",0);
        if (party.equals("cat")){
            for (String i : catStates.keySet()) {
                catStates.replace(i, 10000000);
            }
        }
        else {
            for (String i : dogStates.keySet()) {
                dogStates.replace(i, 10000000);
            }
        }

    }

    public int showDay(){
        return day;
    }

    public double showBudget(){
        return budget;
    }

}
