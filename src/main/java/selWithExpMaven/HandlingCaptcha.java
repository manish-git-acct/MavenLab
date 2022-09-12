package selWithExpMaven;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingCaptcha {
WebDriver driver;
	@Test
	public void captcha1()
	{
		System.setProperty("webdriver.chrome.driver", "//Users//manishsehgal//cucumber-workspace//chromedriver");		
		driver=new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Simple-Math-Captcha-Plugin-for-jQuery-ebcaptcha/demo/");
		driver.manage().window().maximize();
		String str=driver.findElement(By.id("ebcaptchatext")).getText();
		System.out.println(str);
		String str1=str.substring(8, 9);
		System.out.println(str1);
		String str2=str.substring(12,13);
		System.out.println(str2);
		Integer res=Integer.valueOf(str1) + Integer.valueOf(str2);
		driver.findElement(By.id("ebcaptchainput")).sendKeys(String.valueOf(res));
		boolean chkBtnEnable=driver.findElement(By.xpath("//*[@id=\"form\"]/input[2]")).isEnabled();
		System.out.println(chkBtnEnable);
		if(chkBtnEnable==true)
		{
			System.out.println("Button enabled");
			driver.findElement(By.xpath("//*[@id=\"form\"]/input[2]")).click();
		}
		else
		{
			System.out.println("Button not enabled");
		}
		driver.quit();
	}
	
	@Test
	public void captcha2()
	{
		System.setProperty("webdriver.chrome.driver", "//Users//manishsehgal//cucumber-workspace//chromedriver");		
		driver=new ChromeDriver();
		driver.get("http://www.nammregister.org.uk/test.asp");
		driver.manage().window().maximize();
		String captchaText=JOptionPane.showInputDialog("Enter your captcha");
		System.out.println(captchaText);
		driver.findElement(By.id("captchacode")).sendKeys(captchaText);
		driver.findElement(By.id("btnTest")).click();
		String title=driver.getTitle();
		System.out.println("title="+title);
		driver.quit();
	}
}
