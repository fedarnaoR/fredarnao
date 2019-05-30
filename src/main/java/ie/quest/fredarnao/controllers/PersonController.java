package ie.quest.fredarnao.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ie.quest.fredarnao.PersonService;
import ie.quest.fredarnao.model.Person;

@Controller
@RequestMapping("/people")
public class PersonController {
	@RequestMapping("/list")
	public String listPeople(Model model) {
		//I sort the list according to the creationDate field.
		List<Person> list = new ArrayList<Person>(); 
		service.listPeople().forEach(list::add);
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person arg0, Person arg1) {
				if (arg0 == null || arg1 == null || arg0.getCreationDate() == null || arg1.getCreationDate() == null) return 0;
				return (int)(arg0.getCreationDate().getTime() - arg1.getCreationDate().getTime());
			}			
		});
	
		//I save the list of people in the model in order to use in the list template.
		model.addAttribute("list", list);
		//Going to list template.
		return "people/list.html";
	}
	
	@RequestMapping("/newperson")
	public String newPerson() {
		return "people/newperson.html";
	}
	
	@RequestMapping("/insert") 
	public String insert(Person person, Model model) {
		//If I can save the record then set the variable error to false. After I get the list of people
		//and go to list template.
		if (service.newRecord(person)) {
			model.addAttribute("error", false);
			return listPeople(model);
		//If I can not save the record then set the variable to true and go to newperson template.
		} else {
			model.addAttribute("error", true);
			return "people/newperson.html";
		}
	}
	
	@RequestMapping("")
	public String land() {
		return "people/land.html";
	}
	
	@Autowired
	private PersonService service;
}
