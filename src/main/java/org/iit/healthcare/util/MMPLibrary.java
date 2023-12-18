package org.iit.healthcare.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMPLibrary {
	WebDriver driver;
	 public MMPLibrary(WebDriver driver)
	{
		this.driver = driver;
	}
	 
	public WebElement waitforElementToBeDisplayed(By locator, int secs)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul#breadcrumbs>li")));
		WebElement e= driver.findElement(By.cssSelector("ul#breadcrumbs>li"));
		return e;

	}
	 
 
	 
}
