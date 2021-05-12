package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import browser_setups.BrowserSimple;

public class AssignEven extends BrowserSimple {
	
	public static void main(String[] args) throws InterruptedException {
		
		//WAS to select the even options from multi select dropdown?
		
		browserSetup("chrome","C:\\Users\\warlo\\Desktop\\Drop Down.html");
		
		WebElement multi = driver.findElement(By.id("multi"));
		
		WebElement single=driver.findElement(By.id("single"));
		
		Select sel=new Select(multi);
		Select ssel=new Select(single);
		
		System.out.println("Is Drop Down Menu Multi Select--->"+ sel.isMultiple());
		System.out.println("Is Drop Down Menu Multi Select--->"+ ssel.isMultiple());
		
		int size=sel.getOptions().size();
		
		for (int i = 0; i <size; i++) 
		{
			if (i%2==0) 
			{
				sel.selectByIndex(i);		
			}
				
		}
		List<WebElement> printsel = sel.getAllSelectedOptions();
		for (WebElement webElement : printsel) {
			System.out.println(webElement.getText());		
		}
			
	
		Thread.sleep(1000);
		//driver.close();
	}
			
}
	
	

