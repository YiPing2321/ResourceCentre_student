
public class Chromebook extends Item{
	private String os;

	public Chromebook(String assetTag, String description, String os) {
		super(assetTag, description);
		this.os = os;
	}

	public String getOs() {
		return os;
	}
	
	public String toString(){
		String output = "";
		// Write your codes here
<<<<<<< HEAD
		
		   super.toString();
		    output += "Optical Zoom: " + os + "\n";
		  
=======
		output += String.format("%s,%s,%d",this.getAssetTag(),this.getDescription(),this.getOs());
>>>>>>> branch 'master' of https://github.com/YiPing2321/ResourceCentre_student.git
		return output;
	}
}


