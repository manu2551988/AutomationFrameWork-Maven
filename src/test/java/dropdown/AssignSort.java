package dropdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import browser_setups.BrowserSimple;

public class AssignSort extends BrowserSimple {
	
	public static void main(String[] args) throws InterruptedException {
		
		//WAS to select all the elements from dropdown and print them in Ascending Order?
		
		browserSetup("chrome","C:\\Users\\warlo\\Desktop\\Drop Down.html");
		
		WebElement multi = driver.findElement(By.id("multi"));		
		Select sel=new Select(multi);
		List<WebElement> options = sel.getOptions();
		
		ArrayList<String> newList=new ArrayList<String>();
		for (WebElement webElement : options) {
			newList.add(webElement.getText());
			
		}
		System.out.println("Unsorted List-->"+newList);
		
		ArrayList<String> sortList=newList;
		Collections.sort(sortList);
		
		System.out.println("Sorted List-->"+sortList);
		
	}
			
}
	
	

