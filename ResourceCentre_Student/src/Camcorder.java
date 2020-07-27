
public class Camcorder extends Item{
	private int opticalZoom;

	public Camcorder(String assetTag, String description, int opticalZoom) {
		super(assetTag, description);
		this.opticalZoom = opticalZoom;
	}

	public int getOpticalZoom() {
		return opticalZoom;
	}
	
	public String toString(){
		String output = "";
		//Marvin
		// Write your codes here
		output += String.format("%s,%s,%d",this.getAssetTag(),this.getDescription(),this.getOpticalZoom());
		return output;
	}
}

