package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Contact;

class ContactTest {
	
	private static Contact contact;
	
	@BeforeEach
	void resetContact() {
		contact = new Contact();
	}

	@Test
	void testContactID() {
		Contact contactID = new Contact("1234567890","Butters","Stotch","8008 South Park Way","9798687575");
		Assertions.assertTrue(contactID.getContactID().equals("1234567890"));
		Assertions.assertTrue(contactID.getAddress().equals("8008 South Park Way"));
		Assertions.assertTrue(contactID.getFirstName().equals("Butters"));
		Assertions.assertTrue(contactID.getPhoneNum().equals("9798687575"));
		
		
		assertThrows(IllegalArgumentException.class, () -> {
		new Contact("12345","Butters","Stotch","8008 Southton Park Way","97948687575");
		}); 
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Butters","Stotch","8008 Southton Park Way","9798687575");
		});
		
	}
	
	@Test
	void testSetPhoneNum() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNum("97986875754321");
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Butters","Stotch","8008 South Park Way", null);
			});	
		});
	}
	
	@Test
	void testSetAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("3232 Wallaby Jumper Jormp Jamp Way");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Butters","Stotch",null,"9798687575");
		});
	}
	
	@Test
	void testSetFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("Kikomemolilohiho");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", null,"Stotch","8008 South Park Way","9798687575");
		});
	}
	
	@Test
	void testSetLasttName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("Onomatopoeia");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Butters", null,"8008 South Park Way","9798687575");
		});
	}

}

