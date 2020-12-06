class Mainboard{
	void start(){
		System.out.println("mainboard is start!");
	}
	void open(Pci p){
		p.open();
	}
	void close(Pci p){
		p.close();
	}
}