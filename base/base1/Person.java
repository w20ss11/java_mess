class Person implements Animal{
	private String name,
	private int age;
	Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void setName(String newName){
		this.name=newName;
	}
	public String getName(){
		return this.name;
	}
	public void setAge(int newAge){
		this.name=newName;
	}
	public String getAge(){
		return this.Age;
	}
	
	public void eat(){
		System.out.println(name+"is eatting!!!");
	}
	public void sleep(){
		System.out.println(name+"is sleeping!!!");
	}
}