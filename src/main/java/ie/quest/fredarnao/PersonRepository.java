package ie.quest.fredarnao;

import org.springframework.data.repository.CrudRepository;

import ie.quest.fredarnao.model.Person;

public interface PersonRepository extends CrudRepository<Person, String> {}
