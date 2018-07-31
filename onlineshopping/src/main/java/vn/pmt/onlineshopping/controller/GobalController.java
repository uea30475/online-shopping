package vn.pmt.onlineshopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import vn.pmt.onlineshopping.model.UserModel;
import vn.pmt.shoppingbackend.dao.UserDAO;
import vn.pmt.shoppingbackend.dto.User;

@ControllerAdvice
public class GobalController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel = null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		
		if(session.getAttribute("userModel")==null) {
			
			//add user model
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = userDAO.getByEmail(authentication.getName());
			if(user!=null) {
				//create a new UserModel object to pass the user details
				
				userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName()+ " " + user.getLastName());
				
				if(userModel.getRole().equals("USER")) {
					//set the cart only if is a buyer
					userModel.setCart(user.getCart());
				}
				//set the  userModel in the session
				
				session.setAttribute("userModel", userModel);
			}
		}
		
		return	(UserModel) session.getAttribute("userModel");
		
	}
	

}
