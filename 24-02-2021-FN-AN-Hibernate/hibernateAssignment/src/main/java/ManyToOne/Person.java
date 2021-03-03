package ManyToOne;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	
	@Id
	private int id;
	private String name;
	
	@OneToMany(mappedBy="person")
	private List<Sim> sims = new ArrayList<Sim>();

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

	public List<Sim> getSims() {
		return sims;
	}

	public void setSims(List<Sim> sims) {
		this.sims = sims;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", sims=" + sims + "]";
	}
	

}
