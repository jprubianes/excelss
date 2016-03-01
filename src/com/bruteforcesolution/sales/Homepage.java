package com.bruteforcesolution.sales;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
	
	WebDriver driver;
	By signin = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	
	public Homepage(WebDriver Argdriver){
		this.driver = Argdriver;
	}
	
	public void signinlink(){
		driver.findElement(signin).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

}
