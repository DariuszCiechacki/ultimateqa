package library.modules.practice.constructor;

public class PersonalData {
    public String firstName;
    public String lastName;
    public int age;
    public String nationality;

    public PersonalData(String firstName, String lastName, int age, String nationality){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
    }

    public void hobby(){
        System.out.println(firstName + " " + lastName + " loves cocaine");
    }
}
