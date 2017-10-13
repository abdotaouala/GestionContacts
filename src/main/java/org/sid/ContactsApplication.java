package org.sid;

import java.util.Date;

import org.sid.entities.Contact;
import org.sid.org.sid.dao.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactsApplication implements CommandLineRunner{
	@Autowired
	private ContactRepository contactRepository;
	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		contactRepository.save(new Contact("abdo", "simo",new Date(), "abdo@gmail.com", 8787878, "ghy.gif"));	
		contactRepository.save(new Contact("brihim", "ali",new Date(), "ali@gmail.com", 548765, "ghhghy.gif"));	
		contactRepository.save(new Contact("khalid", "yousef",new Date(), "yousef@gmail.com", 21254, "ghfjhy87.gif"));	
		contactRepository.save(new Contact("karim", "ridwan",new Date(), "ridwan@gmail.com", 9965, "gfg4.gif"));	

	}
}
