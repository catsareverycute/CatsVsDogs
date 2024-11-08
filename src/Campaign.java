public class Campaign {
private int day = 1;
private int vote = 1;
private String name;
private String party;
    public Campaign(String name, String party) {
        this.name = name;
        this.party = party;
    }
    public int showDay(){
        return day;
    }
}
