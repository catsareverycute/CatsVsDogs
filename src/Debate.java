public class Debate {
    private String oppName;
    private int votes;
    private String party;
    private String name;
    private int oppVotes;

    public Debate(String name, String party) {
        this.name = name;
        this.party = party;
    }

    public String debateMessage(int i) {
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

    public boolean checkResponse(int response) {
        return (response > 3 || response < 0);
    }

    public void randomName() {
        String[] names = {"Mr. John", "Mr. James", "Mr. Michael", "Mr. Robert", "Mr. David", "Mr. William", "Mr. Richard", "Mr. Joseph",
                "Mr. Thomas", "Mr. Christopher", "Mr. Charles", "Mr. Daniel", "Ms. Mary", "Ms. Patricia", "Ms. Jennifer", "Ms. Linda", "Ms. Elizabeth",
                "Ms. Barbara", "Ms. Susan", "Ms. Jessica", "Ms. Karen", "Ms. Sarah", "Ms. Lisa", "Ms. Nancy", "Mr. Das"};
        oppName = names[(int) (Math.random() * 25)];
    }

    public String showName() {
        return "Mx. " + name;
    }

    public String showOppName() {
        return oppName;
    }

    public String oppRandomLine() {
        String[] randomLines = {"War is bad.", "World peace is good.", "World hunger is bad.", "Homelessness is bad.",
                "Climate change is bad.", "Clean water is good.", "Protecting the environment is good.", "Inequality is bad.",
                "Criminals are bad.", "Crime is bad.", "Education is good.", "Unemployment is bad.", "Disease is bad."};
        return randomLines[(int) (Math.random() * 13)];
    }

    public void oppDebateVotes() {
        oppVotes += (int) ((Math.random() * 100000) + 50000);
    }

    public void debateVotes(int response) {
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
        System.out.println(votes);
    }

    public void finalWords(String finalWords) {
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
    public int yourVotes() {
        return votes;
    }
    public int oppVotes() {
        return oppVotes;
    }
}
