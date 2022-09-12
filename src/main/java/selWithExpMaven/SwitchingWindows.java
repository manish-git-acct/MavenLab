package selWithExpMaven;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwitchingWindows {

	@Test
	public void switchWin()
	{
		System.setProperty("webdriver.chrome.driver", "//Users//manishsehgal//cucumber-workspace//chromedriver");		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		Set<String> allWin=driver.getWindowHandles();
		System.out.println("total windows="+allWin.size());
		String win1=null;
		String win2=null;
		Iterator<String> itr=allWin.iterator();
		while(itr.hasNext())
		{
			win1=itr.next();
			win2=itr.next();
		}
		System.out.println("Window1="+win1);
		System.out.println("Window2="+win2);
		System.out.println("Window title="+driver.getTitle());
		driver.switchTo().window(win2);
		System.out.println("Window title="+driver.getTitle());
		WebElement logButton = driver.findElement(By.id("w3loginbtn"));
//		String color = logButton.getAttribute("background-color");
//		System.out.println("Color = " + color);
		Boolean logEnabled = driver.findElement(By.id("w3loginbtn")).isEnabled();
		if (logEnabled)
		{
			System.out.println("Login button is enabled");
		}
		else
		{
			System.out.println("Login button is not enabled");
		}
		driver.quit();
		
		
		
	}
}
