import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Person implements CheckPerson{

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    ArrayList<Person> people;

    public enum Sex {
        MALE, FEMALE
    }

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress){
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public Person create (String name, LocalDate birthday, Sex gender, String emailAddress){
        Person createdPerson = new Person(name, birthday, gender, emailAddress);
        people.add(createdPerson);
        return createdPerson;
    }

    public int getAge() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }

    public void printPerson() {
        System.out.format("Person: { Name: %0$-20s, Birthday: %s, Gender: %0$-6s, Email Address: %0$-30s}\n", name, birthday, gender, emailAddress);
    }

    @Override
    public Boolean test(Person person) {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ArrayList<Person> getPeople(){
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }
}
