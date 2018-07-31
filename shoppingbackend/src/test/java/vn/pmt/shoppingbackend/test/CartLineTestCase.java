package vn.pmt.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vn.pmt.shoppingbackend.dao.CartLineDAO;
import vn.pmt.shoppingbackend.dao.ProductDAO;
import vn.pmt.shoppingbackend.dao.UserDAO;
import vn.pmt.shoppingbackend.dto.Cart;
import vn.pmt.shoppingbackend.dto.CartLine;
import vn.pmt.shoppingbackend.dto.Product;
import vn.pmt.shoppingbackend.dto.User;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	private Product product =null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;
	
	@BeforeClass
	public static void init() {
		 context = new AnnotationConfigApplicationContext();
		 context.scan("vn.pmt.shoppingbackend");
		 context.refresh();
		 productDAO = 	(ProductDAO) context.getBean("productDAO");
		 userDAO = 	(UserDAO) context.getBean("userDAO");
		 cartLineDAO = 	(CartLineDAO) context.getBean("cartLineDAO");

	}
	
	@Test
	public void testAddNewCart() {
		//get user
		 user = userDAO.getByEmail("admin2@gmail.com");
		//fetch the cart
		 cart = user.getCart();
		 product = productDAO.get(1);
		 
		 //create new cart line
		 cartLine = new CartLine();
		 cartLine.setBuyingPrice(product.getUnitPrice());
		 cartLine.setProductCount(cartLine.getProductCount()+1);
		 cartLine.setTotal(cartLine.getProductCount()*product.getUnitPrice());
		 cartLine.setAvailable(true);
		 cartLine.setCartId(cart.getId());
		 cartLine.setProduct(product);
		 
		 assertEquals("failed to add new cartLine",true,cartLineDAO.add(cartLine));
		
		 //update cart
		 
		 cart.setGrandTotal(cart.getGrandTotal()+cartLine.getTotal());
		 cart.setCartLines(cart.getCartLines()+1);
		 
		 assertEquals("failed to update the cart",true,cartLineDAO.updateCart(cart));
	}
	
	
	
}
