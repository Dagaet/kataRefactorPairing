package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import algorithm.PersonComparator;
import algorithm.AgeDistant;
import algorithm.Finder;
import algorithm.Person;

public class FinderTests {

    Person sue = new Person();
    Person greg = new Person();
    Person sarah = new Person();
    Person mike = new Person();

    @Before
    public void setup() {
        sue.name = "Sue";
        sue.birthDate = new Date(50, 0, 1);
        greg.name = "Greg";
        greg.birthDate = new Date(52, 5, 1);
        sarah.name = "Sarah";
        sarah.birthDate = new Date(82, 0, 1);
        mike.name = "Mike";
        mike.birthDate = new Date(79, 0, 1);
    }

    @Test
    public void returns_Empty_Results_When_Given_Empty_List() {
        List<Person> list = new ArrayList<>();
        Finder finder = new Finder(list);

        PersonComparator result = finder.Find(AgeDistant.CLOSEST);

        assertEquals(null, result.olderPerson);
        assertEquals(null, result.youngerPerson);
    }

    @Test
    public void returns_Empty_Results_When_Given_One_FT() {
        List<Person> list = new ArrayList<>();
        list.add(sue);

        Finder finder = new Finder(list);

        PersonComparator result = finder.Find(AgeDistant.CLOSEST);

        assertEquals(null, result.olderPerson);
        assertEquals(null, result.youngerPerson);
    }

    @Test
    public void returns_One_Two_For_Two_FTs() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(greg);
        Finder finder = new Finder(list);

        PersonComparator result = finder.Find(AgeDistant.CLOSEST);

        assertEquals(sue, result.olderPerson);
        assertEquals(greg, result.youngerPerson);
    }

    @Test
    public void returns_Two_Two_For_Two_FTs() {
        List<Person> list = new ArrayList<>();
        list.add(mike);
        list.add(greg);
        Finder finder = new Finder(list);

        PersonComparator result = finder.Find(AgeDistant.FURTHEST);

        assertEquals(greg, result.olderPerson);
        assertEquals(mike, result.youngerPerson);
    }

    @Test
    public void returns_Two_Two_For_Four_FTs() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        Finder finder = new Finder(list);

        PersonComparator result = finder.Find(AgeDistant.FURTHEST);

        assertEquals(sue, result.olderPerson);
        assertEquals(sarah, result.youngerPerson);
    }

    @Test
    public void returns_One_Two_For_Four_FTs() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        Finder finder = new Finder(list);

        PersonComparator result = finder.Find(AgeDistant.CLOSEST);

        assertEquals(sue, result.olderPerson);
        assertEquals(greg, result.youngerPerson);
    }

}
