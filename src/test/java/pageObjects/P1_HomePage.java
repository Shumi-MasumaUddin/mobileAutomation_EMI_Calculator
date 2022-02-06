package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class P1_HomePage {

	public P1_HomePage(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	//public By RunEMI_Calculator = By.id("com.continuum.emi.calculator:id/btnStart");
	@AndroidFindBy(id="com.continuum.emi.calculator:id/btnStart")
	public WebElement RunEMI_Calculator; 
	
	
}
