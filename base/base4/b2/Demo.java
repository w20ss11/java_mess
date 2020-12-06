class Demo{
	public static void main(String[] args){
		Mainboard m=new Mainboard();
		m.start();
		Netcard netcard=new Netcard();
		m.open(netcard);
		
		Soundcard soundcard=new Soundcard();
		m.open(soundcard);
	}
}