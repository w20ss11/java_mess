class Soundcard implements Pci{
	public void open(){
		System.out.println("Soundcard is open!");
	}
	public void close(){
		System.out.println("Soundcard is close!");
	}
}