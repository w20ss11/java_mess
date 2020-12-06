class objori2{
	public static void main(String[] args){
		person p=new person();
		p.speak();
		p.speak("you are a sb!");
	}
}
class person{
	void speak(){
		System.out.println("the person is speaking");
	}
	void speak(String str){
		System.out.println("the person is saying:"+str);
	}
}