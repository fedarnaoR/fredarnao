package ie.quest.fredarnao;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.quest.fredarnao.model.Person;

@Service
public class PersonService {
	public boolean newRecord(Person person) {
		boolean res = false;
		//Testing if exists a person with this PPSN.
		Optional<Person> per = repository.findById(person.getPpsNumber());
		res = !per.isPresent();
		//If not exist, then it inserts the person and returns true, 
		//else it does nothing and returns false.
		if (res) {
			person.setCreationDate(new Date());
			repository.save(person);
		}
		return res;
	}
	
	public Iterable<Person> listPeople() {
		return repository.findAll();
	}
	
	//This one is used in tests to clean data.
	public void deleteAll() {
		repository.deleteAll();
	}
	
	@Autowired
	private PersonRepository repository;
}
