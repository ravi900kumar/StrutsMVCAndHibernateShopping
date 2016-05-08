package java9r.controller.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import entites.com.Items;
import entites.com.Product;
import java9r.dao.com.ProductDAOImpl;

public class ShoppingCartController {

	private int id;
	
	 ProductDAOImpl product=new ProductDAOImpl();
	    private List<Product> listproduct=new ArrayList<Product>();

	    
	     	private int isExisting(int id){
	    		Map<String, Object> session=ActionContext.getContext().getSession();
				List<Items> cart = (List<Items>) session.get("cart");

				for (int i = 0; i < cart.size(); i++)

					if (cart.get(i).getProduct().getId() == id)
						return i;

				return -1;
			}
	      
	    
	    
	public String ordernow(){
		
		Map<String, Object> session=ActionContext.getContext().getSession();
		if (session.get("cart") == null) {
			List<Items> cart = new ArrayList<Items>();
			cart.add(new Items(this.product.find(id), 1));
			
			
			session.put("cart", cart);
		} else {
			List<Items> cart = (List<Items>) session.get("cart");

			// using method isExisting here
			int index = isExisting(id);
			if (index == -1)
				cart.add(new Items(this.product.find(id), 1));
			else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}

			session.put("cart", cart);
		}

		
		return "success";
	}

	public String delete(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		List<Items> cart = (List<Items>) session.get("cart");
		int index = isExisting(id);
		cart.remove(index);
		session.put("cart", cart);
		return "success";
	}
	
	
	public ProductDAOImpl getProduct() {
		return product;
	}

	public void setProduct(ProductDAOImpl product) {
		this.product = product;
	}

	public List<Product> getListproduct() {
		return listproduct;
	}

	public void setListproduct(List<Product> listproduct) {
		this.listproduct = listproduct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
