package container;

public class Ack {
	
	private String alias;
	private String result;
	
	public Ack(String alias, String result) {
		this.alias = alias;
		this.result = result;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public String getResult() {
		return this.result;
	}
	
	

}
