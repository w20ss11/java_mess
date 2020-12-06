class Demo4{
	public static void main(String[] args){
		int k=0;
		for(int i=0;i<=20;i++){
			if((100-7*i)%4==0)
				k++;
		}
		System.out.println(k+"ways!");
	}
}