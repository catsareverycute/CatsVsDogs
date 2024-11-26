public class Debate {
    private String oppName; // opponent's name
    private int votes; // votes gained from debate
    private String party; // your party
    private String name; // your name
    private int oppVotes; // opponent's votes gained from debate

    public Debate(String name, String party) { // creates object storing name and party
        this.name = name;
        this.party = party;
    }

    public String debateMessage(Integer i) { // returns a string of dialogue, questions, and options based on i (method used in a for loop and i is the varible being incremented)
        String message = "";
        if (i == 0) {
            message = "The Presidential Debate is today! Let's go to the Bird News Station!\n\nBird: Welcome to this year's Presidential Debate! I'm your host, Bird, and I'll be asking these candidates some questions.\nOur candidates are " + showName() + " and " + showOppName() + "!\nNow, " + showName() + ". What are your plans regarding staying indoors for this nation?\nChoose a response: \n1. I will allow our citizens to stay inside for as long as they want!\n2. Citizens will have to go outside each day to be healthy and have fun!\n3. I wouldn't stay inside for a long time, but sometimes, you don't have to go outside everyday.";
        }
        if (i == 1){
            message = "Bird: Alright! How about you, " + showOppName() + "?\n" + showOppName() + ": " + oppRandomLine() + "\nBird: Wow! Tell me, " + showName() + ". How will you accommodate for the other party? Choose a response: \n1. Everyone gets any snacks they want!\n2. Everyone can sleep when they want!\n3. Everyone gets all the luxuries!";
        }
        if (i == 2) {
            message = "Bird: And now, " + showOppName() + ", what do you have to say?\n" + showOppName() + ": " + oppRandomLine() + "\nBird: Final question to you both. How will you lead? Choose a response: \n1. From the comfort of my cardboard box so I can always be on lookout!\n2. At the front by the doorstep of endless posibilities!\n3. I'll adapt according to the situation.";
        }
        if (i == 3) {
            message = "Bird: "+ showOppName() + ", what is your answer?\n" + showOppName() + ": " + oppRandomLine() + "\nBird: Any final words from you two?";
        }
        return message;
    }

    public boolean checkResponse(Integer response) { // checks response to see if it's valid
        return (response > 3 || response < 0);
    }

    public void randomName() { // generates a random name and stores it in oppName variable
        String[] names = {"Mr. John", "Mr. James", "Mr. Michael", "Mr. Robert", "Mr. David", "Mr. William", "Mr. Richard", "Mr. Joseph",
                "Mr. Thomas", "Mr. Christopher", "Mr. Charles", "Mr. Daniel", "Ms. Mary", "Ms. Patricia", "Ms. Jennifer", "Ms. Linda", "Ms. Elizabeth",
                "Ms. Barbara", "Ms. Susan", "Ms. Jessica", "Ms. Karen", "Ms. Sarah", "Ms. Lisa", "Ms. Nancy", "Mr. Das"};
        oppName = names[(int) (Math.random() * 25)];
    }

    public String showName() {  // shows name with Mx.
        return "Mx. " + name;
    }

    public String showOppName() { // shows opponent name 
        return oppName;
    }

    public String oppRandomLine() { // generates random string for opponent to say and returns it
        String[] randomLines = {"War is bad.", "World peace is good.", "World hunger is bad.", "Homelessness is bad.",
                "Climate change is bad.", "Clean water is good.", "Protecting the environment is good.", "Inequality is bad.",
                "Criminals are bad.", "Crime is bad.", "Education is good.", "Unemployment is bad.", "Disease is bad."};
        return randomLines[(int) (Math.random() * 13)];
    }

    public void oppDebateVotes() { // gives opponent an amount of votes in a certain range
        oppVotes += (int) ((Math.random() * 100000) + 50000);
    }

    public void debateVotes(Integer response) { // gives user votes depending on their party and response
        if (party.equals("cat")) {
            if (response == 1) {
                votes += 100000;
            }
            else if (response == 2) {
                votes += 50000;
            }
            else if (response == 3) {
                votes += 150000;
            }
        }
        else if (party.equals("dog")) {
            if (response == 1) {
                votes += 50000;
            }
            else if (response == 2) {
                votes += 100000;
            }
            else if (response == 3) {
                votes += 150000;
            }
        }
    }

    public void finalWords(String finalWords) { // checks final words inputted by user to see if they gain additional votes
        finalWords = finalWords.toLowerCase();
        if ((finalWords.contains("cat")) || (finalWords.contains("dog"))) {
            votes += 100000;
        }
        if ((finalWords.contains("cute")) || (finalWords.contains("adorable"))) {
            votes += 100000;
        }
        if ((finalWords.contains("vote"))) {
            votes += 50000;
        }
    }
    public int yourVotes() { // returns total amount of debate votes for user
        return votes;
    }
    public int oppVotes() { // returns total amount of debate votes for opponent
        return oppVotes;
    }
}
