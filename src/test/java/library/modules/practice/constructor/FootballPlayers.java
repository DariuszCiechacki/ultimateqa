package library.modules.practice.constructor;

public class FootballPlayers extends PersonalData{
    public String footballClub;

    public FootballPlayers(String firstName, String lastName, int age, String footballClub) {
        super(firstName, lastName, age);
        this.footballClub = footballClub;
    }

    public void displayMessage(){
        System.out.println(firstName + " " + lastName + " plays for " + footballClub + displayStadiumName());
    }

    //Overwriting method
    public void hobby(){
        System.out.println(firstName + " " + lastName + " loves going to the gym");
    }

    private String displayStadiumName(){
        if (footballClub.equals("Manchester United")){
            return " at the Old Trafford Stadium";
        }
        return "";
    }

    public void appearances(int club, int national){
        System.out.println(club + national + " total games this season");
    }

    public void appearances(int club, int national, int friendlies){
        System.out.println(club + national + friendlies + " total games this season");
    }
}
