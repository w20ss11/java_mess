class Manager extends Employee{
	private int bonus;
	Manager(String name,int id,int pay,int bonus){
		super(name,id,pay);
		this.bonus=bonus;
	}
	
	public void work(){
		System.out.println("Manager is working!");
	}
}