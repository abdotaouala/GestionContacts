package org.sid.web;

import java.util.List;

import org.sid.entities.Contact;
import org.sid.org.sid.dao.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ContactRestService {

	@Autowired
	private ContactRepository contactRepository;
	@RequestMapping(value="/contacts",method=RequestMethod.GET)
	public List<Contact> getContacts(){
		return contactRepository.findAll();
	}
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.GET)
	public Contact getContact(@PathVariable Long id){		
		return contactRepository.findOne(id);
	}
	@RequestMapping(value="/contacts",method=RequestMethod.POST)
	public Contact save(@RequestBody Contact contact){
		return contactRepository.save(contact);
	}
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.PUT)
	public Contact update(@RequestBody Contact contact,@PathVariable Long id){
		contact.setId(id);
		return contactRepository.save(contact);
	}
	@RequestMapping(value="/chercher",method=RequestMethod.GET)
	public Page<Contact > chercher(@RequestParam(name="nom",defaultValue="") String nom,@RequestParam(name="page",defaultValue="0") int page,@RequestParam(name="size",defaultValue="5") int size){
		return contactRepository.chercher("%"+nom+"%",new PageRequest(page, size));
	}
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id){
		Contact c=contactRepository.findOne(id);
		if(c!=null) {
			contactRepository.delete(c);
			return true;
		}
		else return false;
	}
}
