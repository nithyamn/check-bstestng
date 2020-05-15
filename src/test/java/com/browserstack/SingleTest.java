package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {

        TestStatus ts = new TestStatus();

        SessionId session = ((RemoteWebDriver) driver).getSessionId();
        driver.get("https://www.google.com/ncr");

        ts.mark(session,"failed");

        ts.mark(session,"passed");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack");
        ts.mark(session,"passed");
        element.submit();
        ts.mark(session,"failed");
        Thread.sleep(5000);

        ts.mark(session,"passed");
        String title = driver.getTitle();
        //TestStatus.mark(session,"failed");

        //SessionId session = ((RemoteWebDriver) driver).getSessionId();
        /*System.out.println(session);
        if(title.equals("BrowserStack - Google Search - 1"))
            TestStatus.mark(session,"passed");
        else
            TestStatus.mark(session,"failed");*/

    }
}
