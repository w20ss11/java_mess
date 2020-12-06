class Demo{
	public static void main(String[] args){
		Dao dao=new DatasetJdbc();
		dao.add();
		System.out.println("--------------");
		Dao dao1=new DatasetHibernate();
		dao1.add();
	}
}