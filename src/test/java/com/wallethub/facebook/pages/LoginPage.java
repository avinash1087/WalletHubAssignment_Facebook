package com.wallethub.facebook.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	Properties prop;
	WebDriverWait wait;

	public LoginPage(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	public WebElement username;

	@FindBy(id = "pass")
	public WebElement password;

	@FindBy(css = "input[type=\"submit\"]")
	public WebElement submit;

	@FindBy(xpath = "//*[@id=\"pagelet_composer\"]/div/div")
	public WebElement creatPostTextBox;

	public HomePage login() {
		driver.get(prop.getProperty("url")); //Navigate to Facebook.com
		
		wait = new WebDriverWait(driver, 20);
		
		this.username.sendKeys(prop.getProperty("username")); //Enter Username
		this.password.sendKeys(prop.getProperty("password")); //Enter Password
		this.submit.click();
		
		wait.until(ExpectedConditions.visibilityOf(creatPostTextBox)); //Wait untill Create A Post box is visible
		
		return (new HomePage(driver, prop));

	}

}
