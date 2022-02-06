package pageObjects;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.Utilities;

public class P2_CalculationPage extends Utilities {

	public P2_CalculationPage(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.continuum.emi.calculator:id/etLoanAmount")
	public WebElement Amount;
	
	@AndroidFindBy(id="com.continuum.emi.calculator:id/etInterest")
	public WebElement Interest;
	
	@AndroidFindBy(id="com.continuum.emi.calculator:id/etYears")
	public WebElement Years;
	
	@AndroidFindBy(id="com.continuum.emi.calculator:id/etMonths")
	public WebElement Months;
	
	@AndroidFindBy(id="com.continuum.emi.calculator:id/rbEMI")
	public WebElement rbEMI;
	
	@AndroidFindBy(id="com.continuum.emi.calculator:id/etFee")
	public WebElement ProcessFee;
	
	@AndroidFindBy(id="com.continuum.emi.calculator:id/btnCalculate")
	public WebElement Calculate;
	
	@AndroidFindBy(id="com.continuum.emi.calculator:id/btnReset")
	public WebElement Reset;
	
	@AndroidFindBy(id="com.continuum.emi.calculator:id/btnDetail")
	public WebElement Details;
	
	@AndroidFindBy(id="com.continuum.emi.calculator:id/monthly_emi_result")
	public WebElement res_EMI;
	
	@AndroidFindBy(id="com.continuum.emi.calculator:id/total_interest_result")
	public WebElement res_TotalInt;
	
	@AndroidFindBy(id="com.continuum.emi.calculator:id/processing_fee_result")
	public WebElement res_ProFee;
	
	@AndroidFindBy(id="com.continuum.emi.calculator:id/total_payment_result")
	public WebElement res_TotalPayment;

	public void InputEMIcal(long loan, double interest, int period, double pFee) throws InterruptedException {
		
		rbEMI.click();
		Thread.sleep(2000);
		
		Amount.sendKeys(Long.toString(loan));
		Interest.sendKeys(Double.toString(interest));
		Years.sendKeys(Integer.toString(period));
		ProcessFee.sendKeys(Double.toString(pFee));
		Calculate.click();
		Thread.sleep(2000);
		
	}
	
	public long[] getActualResults() throws InterruptedException {
		  
		  long monthlyEMIVal = getRoundVal(res_EMI.getText()); 
		  long totalInterestVal = getRoundVal(res_TotalInt.getText()); 
		  long processingFeeVal =getRoundVal(res_ProFee.getText()); 
		  long totalPaymentVal = getRoundVal(res_TotalPayment.getText()); 
		  long[] actualVal = { monthlyEMIVal, totalInterestVal, processingFeeVal, totalPaymentVal }; 
		  Thread.sleep(3000); 
		  return actualVal; 
		  }
	
	public void reset() throws InterruptedException {
		Reset.click();
		Thread.sleep(2000);
	}
	
	public void details() throws InterruptedException {
		Details.click();
		Thread.sleep(2000);
	}
		
}
