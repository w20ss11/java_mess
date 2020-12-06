abstract class Employee{
	private int id;
	private String name;
	private int pay;
	
	Employee(String name,int id,int pay){
		this.name=name;
		this.id=id;
		this.pay=pay;
	}
	
	
	public abstract void work();
}