import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {

    Person cloud, tifa, barret, yuffie, cid;
    ArrayList<Person> thePeople = new ArrayList<>();

    @Before
    public void setUp(){
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
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void printPersons() {
        String expected = "Person: { Name: Yuffie Kisaragi     , Birthday: 1991-11-20, Gender: FEMALE, Email Address: ninjaPrincess@square.com      }\n";
        Main.printPersons(thePeople, new CheckPerson() {
            @Override
            public Boolean test(Person person) {
                return person.getAge() <= 30;
            }
        });
        Assert.assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void printPersonsLambda(){
        String expected = "" +
            "Person: { Name: Tifa Lockheart      , Birthday: 1987-05-03, Gender: FEMALE, Email Address: tifa@square.com               }\n" +
            "Person: { Name: Yuffie Kisaragi     , Birthday: 1991-11-20, Gender: FEMALE, Email Address: ninjaPrincess@square.com      }\n";
        Main.printPersons(thePeople, person -> person.getGender() == Person.Sex.FEMALE);
        Assert.assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void main() {
    }
}