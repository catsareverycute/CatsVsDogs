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
}
