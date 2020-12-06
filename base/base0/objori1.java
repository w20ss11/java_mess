class superclass{
	int x;
	superclass(){
		x=10;
	}
	public void doclass(){
		System.out.println("father's doclass method!");
	}
}
class subclass extends superclass{
	int x;
	subclass(){
		super();
		x=100;
	}
	public void doclass(){
		System.out.println("son's doclass method!");
	}
	public void doDemo(){
		int x=1000;
		super.doclass();
		doclass();
		System.out.println("father's x="+super.x);
		System.out.println("son'x="+this.x);
		System.out.println("this method'x="+x);
	}
}
class objori1{
	public static void main(String[] args){
		subclass sub=new subclass();
		sub.doDemo();
	}
}