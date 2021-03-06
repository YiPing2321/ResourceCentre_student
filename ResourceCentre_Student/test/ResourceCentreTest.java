import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void addCamcorderTest() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
	public void addChromebookTest() {
		//Marvin
		//fail("Not yet implemented");
		// write your code here
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addChromebook(chromebookList, cb1);
		assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Chromebook is added same as 1st item of the list?", cb1, chromebookList.get(0));

		// Add another item. test The size of the list is 2?
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test that Chromebook arraylist size is 2?", 2, chromebookList.size());

	}
	
	@Test
	public void retrieveAllCamcorderTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void retrieveAllChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		// Yi Ping
		String output = "";
		for (int i = 0; i < chromebookList.size(); i++) {
			output += String.format("%-10s %-30s %-10s %-10s %-20d\n", chromebookList.get(i).getAssetTag(),
                    chromebookList.get(i).getDescription(), 
                    ResourceCentre.showAvailability(chromebookList.get(i).getIsAvailable()),
                    chromebookList.get(i).getDueDate());
		}
		String allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);
		assertEquals("Check that ViewAllCamcorderlist", output, allChromebook);
	}

	@Test
	public void doLoanCamcorderTest() {
		//Marvin
		//fail("Not yet implemented");
		// write your code here
		//Test if there is valid camcorder arraylist to loan
		assertNotNull("Test if there is valid Camcorder arraylist to loan from", camcorderList);
		assertTrue("Test if camcorder availability is true", cc1.getIsAvailable());
		assertTrue("Test if camcorder availability is true", cc2.getIsAvailable());
	}
	
	@Test
	public void doLoanChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		//Zi En
		 for (int i = 0; i < chromebookList.size() ; i++) {
			 if (chromebookList.get(i).getIsAvailable() == false) {
				 System.out.println("Invalid asset tag");
	         } else {
	             System.out.println("Chromebook " + chromebookList.get(i).getAssetTag() + " loaned out");
	        }
	    }
	}
	
	@Test
	public void doReturnCamcorderTest() {
		//XinRu
		//fail("Not yet implemented");
		// write your code here
		//checked for valid Camcorder arraylist to return to
		assertNotNull("Test if there is valid Camcorder arraylist to return to", camcorderList);
		ResourceCentre.doReturnCamcorder(camcorderList, cc1.getAssetTag());
		assertTrue("Test if item has been returned", cc1.getIsAvailable());
		assertTrue("Test if item has been returned", cc2.getIsAvailable());

	}
	@Test
	public void doReturnChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		//Check that there is a valid chromebook array to return 
		assertNotNull("Test if there is valid ChromeBook arraylist to return to", chromebookList);
		
		//Returned the item
		ResourceCentre.doReturnChromebook(chromebookList, cb1.getAssetTag());
		
		//Test that item is being returned
		assertTrue("Test if item is been returned", cb1.getIsAvailable());
		
		//Test if that item have not been returned
		assertTrue("Test if item is been returned", cb2.getIsAvailable());
		
	}
	//^Done by Guang Hao//
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
