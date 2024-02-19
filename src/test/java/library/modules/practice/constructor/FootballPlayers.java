package library.modules.practice.constructor;

public class FootballPlayers extends PersonalData{
    public String footballClub;

    public FootballPlayers(String firstName, String lastName, int age, String nationality, String footballClub) {
        super(firstName, lastName, age, nationality);
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
}
