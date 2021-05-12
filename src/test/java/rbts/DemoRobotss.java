package rbts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class DemoRobotss {

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		// TODO Auto-generated method stub
		
		Runtime.getRuntime().exec("notepad");
		
		Robot rs= new Robot();
		rs.keyPress(KeyEvent.VK_SHIFT);
		rs.keyPress(KeyEvent.VK_M);
		rs.keyRelease(KeyEvent.VK_SHIFT);
		rs.keyPress(KeyEvent.VK_A);
		rs.keyPress(KeyEvent.VK_N);
		rs.keyPress(KeyEvent.VK_U);
		
		for (int i = 1; i <500; i+=10) {
			rs.mouseMove(200+i, 150);
			Thread.sleep(500);
			
		}
				

	}

}
