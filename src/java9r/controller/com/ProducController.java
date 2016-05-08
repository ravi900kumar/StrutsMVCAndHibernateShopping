package java9r.controller.com;

import java.util.ArrayList;
import java.util.List;

import entites.com.Product;
import java9r.dao.com.ProductDAOImpl;
 
public class ProducController {
	
	 
	 

  ProductDAOImpl product=new ProductDAOImpl();
	    private List<Product> listproduct=new ArrayList<Product>();

	public String index(){ 	
		 this.listproduct=this.product.findAll();
		return "success";
	}

	
	 




	public List<Product> getListproduct() {
		return listproduct;
	}

	public void setListproduct(List<Product> listproduct) {
		this.listproduct = listproduct;
	}

}
