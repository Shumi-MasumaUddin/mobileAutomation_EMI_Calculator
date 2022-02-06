package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import base.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.P1_HomePage;
import pageObjects.P2_CalculationPage;
import utilities.DataSet;

public class RunEMI_Calculator extends Base {
	
	
	int i = 0;
	@Test(dataProvider = "data", dataProviderClass = DataSet.class)
	
	public void myTest(long loan, double interest, int period, double pFee, long mEMI, long tInterest, long tpFee,
			long tPayment) throws InterruptedException, IOException {
		//AndroidDriver<AndroidElement> driver = capabilities();
		
		System.out.println("This is EMI Calculator mob automation test");
		
		P1_HomePage hmPage = new P1_HomePage(driver);
		if(i<1) hmPage.RunEMI_Calculator.click();
		Thread.sleep(5000);
		i++;
		
		P2_CalculationPage p2cal = new P2_CalculationPage(driver);
		p2cal.InputEMIcal(loan, interest, period, pFee);
		Thread.sleep(2000);
		
		long[] actualValue =p2cal.getActualResults();
		assertEquals(actualValue[0], mEMI);
		assertEquals(actualValue[1], tInterest);
		assertEquals(actualValue[2], tpFee);
		assertEquals(actualValue[3], tPayment);
		Thread.sleep(2000);
		p2cal.reset();
		
		Thread.sleep(2000);
		
	}	
}