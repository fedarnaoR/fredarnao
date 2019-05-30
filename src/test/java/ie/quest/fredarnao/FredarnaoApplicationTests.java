package ie.quest.fredarnao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ie.quest.fredarnao.model.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FredarnaoApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void insertTwoPeople() {
		personService.deleteAll();
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(1972, 8, 9);
		Person person1 = new Person("1234567AB", "Federico Arnao", cal.getTime(), "0889793966");
		personService.newRecord(person1);
		
		cal.set(1978, 12, 1);
		Person person2 = new Person("2345678BC", "Erika Najera", cal.getTime(), "088678123");
		personService.newRecord(person2);
		
		Iterable<Person> peopleIter = personService.listPeople();
		List<Person> people = new ArrayList<Person>();
		peopleIter.forEach(people::add);
		
		assertEquals(people.size(), 2);
	}
	
	@Test
	public void insertTwoPeopleWithSamePPSN() {
		personService.deleteAll();
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(1972, 8, 9);
		Person person1 = new Person("1234567AB", "Federico Arnao", cal.getTime(), "0889793966");
		boolean res1 = personService.newRecord(person1);
		
		cal.set(1978, 12, 1);
		Person person2 = new Person("1234567AB", "Erika Najera", cal.getTime(), "088678123");
		boolean res2 = personService.newRecord(person2);
		
		Iterable<Person> peopleIter = personService.listPeople();
		List<Person> people = new ArrayList<Person>();
		peopleIter.forEach(people::add);		
		
		assertEquals(people.size(), 1);
		assertTrue(res1);
		assertTrue(!res2);
	}
	
	@Autowired
	private PersonService personService;
}
