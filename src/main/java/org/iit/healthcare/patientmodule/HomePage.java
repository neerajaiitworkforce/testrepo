package org.iit.healthcare.patientmodule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
	

	private WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}

	public  static Boolean validate(WebDriver driver,String idexpected) {

		driver.findElement(By.id("patient-search")).sendKeys(idexpected);
		//Fetch the displayed given name in the table first row
		String idactual = driver.findElement(By.xpath("//table[@id='patient-search-results-table']/tbody/tr[1]/td[1]")).getText();
		Assert.assertEquals(idexpected,idactual);
		if(idexpected.equalsIgnoreCase(idactual))
		{
			System.out.println("true");
		}
		return true;
	}
	
}
