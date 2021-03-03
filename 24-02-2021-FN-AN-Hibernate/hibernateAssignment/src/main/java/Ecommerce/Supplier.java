package Ecommerce;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Supplier {
	
	@Id
	private int id;
	private String name;
	
	@ManyToMany(mappedBy="suppliers")
	private List<ProductCategory> productCategory = new ArrayList<ProductCategory>();
	
	public void addCategory(ProductCategory pc)
	{
		this.productCategory.add(pc);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<ProductCategory> getProductCategory() {
		return (ArrayList<ProductCategory>) productCategory;
	}

	public void setProductCategory(ArrayList<ProductCategory> productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", productCategory=" + productCategory + "]";
	}

}
