package hello;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Provider {
	@Id
	private final String name;
	private final int amount;
	
	 public Provider() {
		this.name="vide";
		this.amount=0;
		}
	
	public Provider(String name, int amount) {
		super();
		this.name = name;
		this.amount = amount;
	} 
	@Override
	public String toString() {
		return "Provider [name=" + name + ", amount=" + amount + "]";
	}
	public String getName() {
		return name;
	}
	public int getAmount() {
		return amount;
	}
	
}
