import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void main(String[] args) {

        Person cloud, tifa, barret, yuffie, cid;
        ArrayList<Person> thePeople = new ArrayList<>();

        cloud = new Person("Cloud Strife", LocalDate.of(1986, Month.AUGUST,11), Person.Sex.MALE, "buster@square.com");
        tifa = new Person("Tifa Lockheart", LocalDate.of(1987, Month.MAY,3), Person.Sex.FEMALE, "tifa@square.com");
        barret = new Person("Barret Wallace", LocalDate.of(1972, Month.DECEMBER,15), Person.Sex.MALE, "avalancePapa@square.com");
        yuffie = new Person("Yuffie Kisaragi", LocalDate.of(1991, Month.NOVEMBER,20), Person.Sex.FEMALE, "ninjaPrincess@square.com");
        cid = new Person("Cid Highwind", LocalDate.of(1975, Month.FEBRUARY,22), Person.Sex.MALE, "theHighwind@square.com");

        thePeople.add(cloud);
        thePeople.add(tifa);
        thePeople.add(barret);
        thePeople.add(yuffie);
        thePeople.add(cid);

        // Example of a local class
        class checkForOver18 implements CheckPerson{
            @Override
            public Boolean test(Person person){
                return person.getAge() >= 18;
            }
        }
        printPersons(thePeople, new checkForOver18());

        // Example using an anonymous class
        printPersons(thePeople, new CheckPerson() {
            @Override
            public Boolean test(Person person) {
                return person.getAge() >= 18;
            }
        });

        // Example using Lambdas
        printPersons(thePeople, person -> person.getAge() >= 18);
    }

}
