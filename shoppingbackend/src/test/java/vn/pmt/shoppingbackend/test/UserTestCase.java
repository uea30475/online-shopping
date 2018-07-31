package vn.pmt.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vn.pmt.shoppingbackend.dao.UserDAO;
import vn.pmt.shoppingbackend.dto.Address;
import vn.pmt.shoppingbackend.dto.Cart;
import vn.pmt.shoppingbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("vn.pmt.shoppingbackend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	/*@Test
	public void testAdd() {
		user = new User();
		user.setFirstName("Pham");
		user.setLastName("Thi");
		user.setEmail("uea30475@gmail.com");
		user.setContactNumber("0906485739");
		user.setRole("USER");
		user.setPassword("Minhthi30160@");
		
		//add User
		assertEquals("Fails to add user!",true,userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("269 Long thuan - Long phuoc - Quan 9");
		address.setAddressLineTwo("Near Long Gio Coffee");
		address.setCity("TP.HCM");
		address.setState("State 1");
		address.setCountry("VietNam");
		address.setPostalCode("600000");
		address.setBilling(true);
		
		//link the user with the address
		address.setUserId(user.getId());
		
		//add the address
		assertEquals("failed to add the address",true,userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			//create a cart for this user
			cart = new Cart();
			cart.setUser(user);
			assertEquals("failed to add the cart",true,userDAO.addCart(cart));
			
			//add a shipping address for this user
			
			address = new Address();
			address.setAddressLineOne("269 Long thuan - Long phuoc - Quan 9");
			address.setAddressLineTwo("Near Long Gio Coffee");
			address.setCity("TP.HCM");
			address.setState("State 1");
			address.setCountry("VietNam");
			address.setPostalCode("600000");
			//set shipping to true
			address.setShipping(true);
			
			//link it with the user
			address.setUserId(user.getId());
			
			//add the shipping address
			assertEquals("failed to add shipping address",true,userDAO.addAddress(address));
		}
	}*/
	
	
/*	@Test
	public void testAdd() {
		user = new User();
		user.setFirstName("Pham");
		user.setLastName("Thi");
		user.setEmail("uea30475@gmail.com");
		user.setContactNumber("0906485739");
		user.setRole("USER");
		user.setPassword("Minhthi30160@");
		
		//add User
		
		
		
		if(user.getRole().equals("USER")) {
			//create a cart for this user
			cart = new Cart();
			cart.setUser(user);
			//attach cart with user
			user.setCart(cart);
			
		}
		assertEquals("Fails to add user!",true,userDAO.addUser(user));
	}*/
	
/*	@Test
	public void testUpdateCart() {
		//fetch the user by email
		user = userDAO.getByEmail("uea30475@gmail.com");
		//get the cart of user
		cart = user.getCart();
		cart.setGrandTotal(5555);
		cart.setCartLines(2);
		assertEquals("Failed to update the cart!",true,userDAO.updateCart(cart));
	}*/
	
	@Test
	public void testAddAddress() {
		//add user
		user = new User();
		user.setFirstName("Pham");
		user.setLastName("Thi");
		user.setEmail("uea30475@gmail.com");
		user.setContactNumber("0906485739");
		user.setRole("USER");
		user.setPassword("Minhthi30160@");
		assertEquals("Failed to add the user",true,userDAO.addUser(user));
		//add address
		
		address = new Address();
		address.setAddressLineOne("269 Long thuan - Long phuoc - Quan 9");
		address.setAddressLineTwo("Near Long Gio Coffee");
		address.setCity("TP.HCM");
		address.setState("State 1");
		address.setCountry("VietNam");
		address.setPostalCode("600000");
		//set shipping to true
		address.setBilling(true);
		
		//attached the user address
		address.setUserId(user.getId());
		
		assertEquals("Failed to add the address",true,userDAO.addAddress(address));
		
		//add the shipping address
		
		address = new Address();
		address.setAddressLineOne("269 Long thuan - Long phuoc - Quan 9");
		address.setAddressLineTwo("Near Long Gio Coffee");
		address.setCity("TP.HCM");
		address.setState("State 1");
		address.setCountry("VietNam");
		address.setPostalCode("600000");
		//set shipping to true
		address.setShipping(true);
		
		//attached the user address
		address.setUserId(user.getId());;
				
		assertEquals("Failed to add the shipping address",true,userDAO.addAddress(address));
	}
	
/*	@Test
	public void testAddAddress() {
		user = userDAO.getByEmail("uea30475@gmail.com");
		address = new Address();
		address.setAddressLineOne("309 Long thuan - Long phuoc - Quan 9");
		address.setAddressLineTwo("Near Long Thuan Store");
		address.setCity("TP.HCM");
		address.setState("State 2");
		address.setCountry("VietNam");
		address.setPostalCode("600000");
		//set shipping to true
		address.setShipping(true);
		
		//attached the user address
		address.setUser(user);
		
		assertEquals("Failed to add the address",true,userDAO.addAddress(address));
		
	}*/
	
//	@Test
//	public void testGetAddresses() {
//		user = userDAO.getByEmail("uea30475@gmail.com");
//		assertEquals("Failed to fetch the list of address and size does not match",2,
//				userDAO.listShippingAddresses(user).size());
//		
//		assertEquals("Failed to fetch the billing of address and size does not match","TP.HCM",
//				userDAO.getBillingAddress(user).getCity());
//	}
}
