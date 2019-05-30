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
		Optional<Person> per = repository.findById(person.getPpsNumber());
		res = !per.isPresent();
		if (res) {
			person.setCreationDate(new Date());
			repository.save(person);
		}
		return res;
	}
	
	public Iterable<Person> listPeople() {
		return repository.findAll();
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}
	
	@Autowired
	private PersonRepository repository;
}
