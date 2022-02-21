package dropdown;

import browser_setups.BrowserSimple;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AssignLast extends BrowserSimple {
	
	public static void main(String[] args) throws InterruptedException {
		
		//WAS to select the last option in the dropdown?
		
		browserSetup("chrome","C:\\Users\\warlo\\Desktop\\Drop Down.html");
		
		WebElement multi = driver.findElement(By.id("multi"));
		//WebElement single=driver.findElement(By.id("single"));
		
		Select sel=new Select(multi);
		//Select ssel=new Select(single);
		
		int size = sel.getOptions().size();
		sel.selectByIndex(size-1);
		
	}
			
}
	
	

