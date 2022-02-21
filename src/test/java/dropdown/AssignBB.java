package dropdown;

import browser_setups.BrowserSimple;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AssignBB extends BrowserSimple {

	public static void main(String[] args) {
		
		//WAS to select only one option that contains Blackberry?
		
		browserSetup("chrome", "C:\\Users\\warlo\\Desktop\\Drop Down.html");		
//		WebElement multi = driver.findElement(By.id("multi"));
		WebElement multi = driver.findElement(By.xpath("//select[@id='multi']/option[.='Blackberry']"));
		multi.click();
//		Select sel=new Select(multi);
//		sel.selectByVisibleText("Blackberry");
		
		
		

	}

}
