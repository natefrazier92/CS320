package test;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Contact;
import main.ContactService;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
	private static ContactService contactService;
	
	@BeforeEach
	void setUpContactService() {
		contactService = new ContactService();
		contactService.addContact(new Contact("3216540","Bill","Boe","1337 Shire Lane","9998887777"));
	}
	
	
    @Test
    void updateFirstName(){

        Contact c = new Contact("3216540","Bill","Boe","1337 Shire Lane","9998887777");
        ContactService cs = new ContactService();
        cs.addContact(new Contact("3216540","Bill","Boe","1337 Shire Lane","9998887777"));
        cs.updateLastName("3216540", "Boe");
        Assert.assertEquals(c.getLastName(),cs.getContact("3216540").getLastName());
    }
    
    @Test
    void addContactFailsTest() {
    	contactService.addContact(new Contact("3216540","Test","Boe","1337 Shire Lane","9998887777"));
    	Assertions.assertFalse(contactService.getContact("3216540").getFirstName().equals("Test"));

    };
    
    @Test
    void deleteContactSucceedsTest() {
    	Assertions.assertTrue(contactService.deleteContact("3216540"));
    }
    
    @Test
    void updateAddress() {
    	contactService.updateAddress("3216540", "new Address");
    	Assertions.assertEquals(contactService.getContact("3216540").getAddress(), "new Address");
    }
    
	@Test
	void testUpdateAddressWithValidIdAndAddress() {
		assertAll(
			() -> assertTrue(contactService.updateAddress("3216540", "1337 Shire Lane")),
			() -> assertTrue(contactService.getContact("3216540").getAddress() == "1337 Shire Lane")
		);
	}
	
	@Test
	void testUpdateFirstNameWithInvalidId() {
		assertFalse(contactService.updateFirstName("0123456", "Bill"));
	}
	



    
}
    
