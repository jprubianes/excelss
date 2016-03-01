package com.bruteforcesolution.sales;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {

	WebDriver driver;
	By emailbox = By.xpath("//*[@id='email_create']");
	By box2 = By.cssSelector("#email_create");
	By createbutton = By.xpath("//*[@id='SubmitCreate']");
	By emailbox2 = By.xpath("//*[@id='email']");
	By password = By.xpath("//*[@id='email']");
	By signbtn = By.xpath("//*[@id='SubmitLogin']");
	
	
public Loginpage(WebDriver argdriver){
		this.driver = argdriver;		
	}

	public void createacc(String email){
	
		driver.findElement(emailbox).sendKeys(email);
		driver.findElement(createbutton).click();		
		
	}
	
	public String validatecolor(){
		String color = driver.findElement(box2).getCssValue("background-color");
		return color;
	}
	
	public String validatemessage(){

		String message = driver.findElement(By.xpath("//*[@id='create_account_error']/ol/li")).getText();
		System.out.println(message);
		return message;
	}
	
	public String validatecreation(){
		String message = driver.findElement(By.xpath("//*[@id='account-creation_form']/div[1]/h3")).getText();
		System.out.println(message);
		return message;
	}
	
	public void login(String email, String pwd){
		driver.findElement(emailbox2).sendKeys(email);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signbtn).click();
	
	}
	
	public String validatebademail(){
		String message = driver.findElement(By.xpath("//*[@id='center_column']/div[1]/ol/li")).getText();
		System.out.println(message);
		return message;
	}
}
