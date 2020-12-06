class Demo{
	public static void main(String[] args){
		Employee m=new Manager("manager",12,11,13);
		m.work();
		System.out.println("-----------------");
		Employee p=new Pro("pro",11,12);
		p.work();
	}
}