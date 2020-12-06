class objori3{
	public static void main(String[] args){
		line l=new line(3.0);
		System.out.println("line l's cir is:"+l.cir()+"  line's area is :"+l.area());
		tri t=new tri(3.0,4.0,5.0);
		System.out.println("tri l's cir is:"+t.cir()+"  tri's area is :"+t.area());
	}
}
interface shape{
	double Pi=3.14;
	double cir();
	double area();
}
class line implements shape{
	double l;
	line(double l){
		this.l=l;
	}
	public double cir(){
		return l;
	}
	public double area(){
		return 0;
	}
}
class tri implements shape{
	double a,b,c;
	tri(double a,double b,double c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public double cir(){
		return a+b+c;
	}
	public double area(){
		double p=(a+b+c)/2.0;
		double area=Math.sqrt(p*(p-a)*(p-b)*(p-c));
		return area;
	}
}