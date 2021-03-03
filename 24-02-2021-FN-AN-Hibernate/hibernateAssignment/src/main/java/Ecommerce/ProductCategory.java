package Ecommerce;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class ProductCategory {
	@Id
	private int id;
	private String name;
	
	@OneToMany(mappedBy="category")
	private List<Product> products = new ArrayList<Product>();
	
	@ManyToMany
	private List<Supplier> suppliers = new ArrayList<Supplier>();
	
	public void addProduct(Product p)
	{
		this.products.add(p);
	}
	
	public void addSupplier(Supplier s)
	{
		this.suppliers.add(s);
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

	public ArrayList<Product> getProducts() {
		return (ArrayList<Product>) products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public ArrayList<Supplier> getSupplier() {
		return (ArrayList<Supplier>) suppliers;
	}

	public void setSupplier(ArrayList<Supplier> supplier) {
		this.suppliers = supplier;
	}
	
}
