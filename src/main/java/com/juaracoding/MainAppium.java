package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MainAppium {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName","Pixel 2 API 30");
        dc.setCapability("udid","emulator-5554");
        dc.setCapability("platformName","Android");
        dc.setCapability("platformVersion","11");
        dc.setCapability("appPackage","com.google.android.calculator");
        dc.setCapability("appActivity","com.android.calculator2.Calculator");
        dc.setCapability("noReset",true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, dc);
        // 1 + 2 = 3
        MobileElement numOne = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
        numOne.click();
        MobileElement btnAdd = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        btnAdd.click();
        MobileElement numTwo = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        numTwo.click();
        MobileElement equal = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/eq"));
        equal.click();
        MobileElement result = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        String txtResult = result.getText();
        System.out.println(txtResult);

        if(txtResult.equals("3")){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
}