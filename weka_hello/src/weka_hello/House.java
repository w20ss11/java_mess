package weka_hello;

public class House {
	
	public int houseSize;
	public int lotSize;
	public int bedrooms;
	public int granite;
	public int bathroom;
	public int sellingPrice;

	
	public House(int houseSize, int lotSize, int bedrooms, int granite, int bathroom, int sellingPrice) {
		super();
		this.houseSize = houseSize;
		this.lotSize = lotSize;
		this.bedrooms = bedrooms;
		this.granite = granite;
		this.bathroom = bathroom;
		this.sellingPrice = sellingPrice;
	}
	public int getHouseSize() {
		return houseSize;
	}
	public void setHouseSize(int houseSize) {
		this.houseSize = houseSize;
	}
	public int getLotSize() {
		return lotSize;
	}
	public void setLotSize(int lotSize) {
		this.lotSize = lotSize;
	}
	public int getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}
	public int getGranite() {
		return granite;
	}
	public void setGranite(int granite) {
		this.granite = granite;
	}
	public int getBathroom() {
		return bathroom;
	}
	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}
	public int getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
}
