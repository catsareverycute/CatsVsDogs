public class Debate {
    private String oppName;
    private int votes;

    public Debate(String party){

    }
    public void randomName() {
        String[] names = {"Mr. John","Mr. James","Mr. Michael","Mr. Robert","Mr. David","Mr. William","Mr. Richard","Mr. Joseph",
                "Mr. Thomas","Mr. Christopher","Mr. Charles","Mr. Daniel","Ms. Mary","Ms. Patricia","Ms. Jennifer","Ms. Linda","Ms. Elizabeth",
                "Ms. Barbara","Ms. Susan","Ms. Jessica","Ms. Karen","Ms. Sarah","Ms. Lisa","Ms. Nancy","Mr. Das"};
        oppName = names[(int) (Math.random() * 25)];
    }
    public String showOppName() {
        return oppName;
    }
    public String oppRandomLine(){
        String[] randomLines= {"War is bad.","World peace is good.","World hunger is bad.","Homelessness is bad.",
                "Climate change is bad.","Clean water is good.","Protecting the environment is good.","Inequality is bad.",
                "Criminals are bad.","Crime is bad.","Education is good.","Unemployment is bad.","Disease is bad."};
    return randomLines[(int)(Math.random()*13)];
    }
    public void debateVotes(int response){
        if (response == 1) {

            votes += 10000;
        }
    }
}
