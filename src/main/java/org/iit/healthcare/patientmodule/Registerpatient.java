package org.iit.healthcare.patientmodule;
import java.time.Duration;

import org.iit.healthcare.util.AppLibrary;
import org.iit.healthcare.util.MMPLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registerpatient {

	public static  String RegisterPatient(WebDriver driver) 
	{
		 AppLibrary lib=new AppLibrary();
		
		//Register a patient
		driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();

		String randomString = lib.generateRandomString();
		driver.findElement(By.name("givenName")).sendKeys("Given"+randomString);

		driver.findElement(By.name("middleName")).sendKeys("Middl"+randomString);
		driver.findElement(By.name("familyName")).sendKeys("Surname"+randomString);
		driver.findElement(By.id("next-button")).click();


		Select genderSelect = new Select(driver.findElement(By.id("gender-field")));
		genderSelect.selectByVisibleText("Male");
		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.id("birthdateDay-field")).sendKeys("01");

		WebElement birthMonthWE = driver.findElement(By.id("birthdateMonth-field"));
		Select monthSelect = new Select(birthMonthWE);
		monthSelect.selectByIndex(lib.generateRandomMonth());

		//birthMonthWE.findElement(By.xpath("//option[. = 'January']")).click();

		driver.findElement(By.id("birthdateYear-field")).click();
		driver.findElement(By.id("birthdateYear-field")).sendKeys(lib.generateRandomYear(1980));
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("address1")).click();
		driver.findElement(By.id("address1")).click();
		driver.findElement(By.id("address1")).sendKeys("Address1");
		driver.findElement(By.id("address2")).sendKeys("Addres2");
		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.name("phoneNumber")).sendKeys("1231231231");
		driver.findElement(By.id("next-button")).click();

		WebElement dropdown = driver.findElement(By.id("relationship_type"));
		Select relationShipSelect = new Select(dropdown);
		relationShipSelect.selectByVisibleText("Doctor");

		driver.findElement(By.cssSelector(".person-typeahead")).click();
		driver.findElement(By.cssSelector(".person-typeahead")).sendKeys("123awdgsa");
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("submit")).submit();//click on confirm

		//Navigate to homePage
		MMPLibrary mmplib=new MMPLibrary(driver);
		WebElement e = mmplib.waitforElementToBeDisplayed(By.cssSelector("ul#breadcrumbs>li"),30);
		e.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul#breadcrumbs>li")));
		driver.findElement(By.cssSelector("ul#breadcrumbs>li")).click();

		//driver.navigate().to("https://demo.openmrs.org/openmrs/login.htm");

		//click on findA patient record
		driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")).click();
		//I search with expectedGiven id
		String expected = driver.findElement(By.xpath("(//span[@class='recent-lozenge'][normalize-space()='Recent'])[1]/ancestor::td")).getText();

		return expected;

	}


}
