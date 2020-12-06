class Demo{
	public static void main(String[] args){
		Student bs=new BaseStudent();
		bs.sleep();
		bs.study();
		System.out.println("-------------------");
		
		Student as=new AdvStudent();
		as.sleep();
		as.study();
	}
}