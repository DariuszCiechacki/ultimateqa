package library.modules.practice.constructor;

public class PersonalData {
    public String firstName;
    public String lastName;
    public int age;

    public PersonalData(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void hobby(){
        System.out.println(firstName + " " + lastName + " loves cocaine");
    }
}
