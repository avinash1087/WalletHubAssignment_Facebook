package com.wallethub.facebook.pages;

import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	Properties prop;
	WebDriverWait wait;

	public HomePage(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"pagelet_composer\"]/div/div")
	public WebElement creatPostBox;
	
	@FindBy(css = "[role=\"textbox\"]")
	public WebElement creatPostTextBox;
	
	
	@FindBy(xpath = "//button[contains(@type,\"submit\")]/span[text()=\"Share\"]")
	public WebElement shareButton;
	
	public void postAnUpdate() {
		try{
			this.creatPostBox.click();
		}catch(Exception e) {
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ESCAPE).build().perform();
			this.creatPostBox.click();
		}
		this.creatPostTextBox.sendKeys("Hello World");
		shareButton.click();
	}

}
