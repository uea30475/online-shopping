package vn.pmt.shoppingbackend.dao;

import java.util.List;

import vn.pmt.shoppingbackend.dto.Address;
import vn.pmt.shoppingbackend.dto.Cart;
import vn.pmt.shoppingbackend.dto.User;

public interface UserDAO {
	
	//add an user
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	//add and address
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address>listShippingAddresses(User user);
	

	

}
