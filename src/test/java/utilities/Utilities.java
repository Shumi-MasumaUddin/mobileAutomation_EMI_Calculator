package utilities;

import org.openqa.selenium.interactions.ClickAction;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.P2_CalculationPage;

public class Utilities {

		  
	  public long getRoundVal(String val) {
		String value = val.replace(",", "");
		Double dvalue = Double.parseDouble(value);
		long roundVal = (long) Math.round(dvalue);
		return roundVal;
	}

}
