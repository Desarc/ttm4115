package container;

public class Order {

	private String alias;
	private String message;
	
	public Order(String alias, String result) {
		this.alias = alias;
		this.message = result;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public String getMessage() {
		return this.message;
	}
	
}
