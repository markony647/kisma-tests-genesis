package com.kismia.genesis.concise_api;

import com.kismia.genesis.tests.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Quotes;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConciseAPI {

    private WebDriver driver;

    public ConciseAPI(WebDriver driver) {
        this.driver = driver;
    }

    public By findByText(String text) {
        return By.xpath(".//*/text()[normalize-space(.) = " + Quotes.escape(text) + "]/parent::*");
    }

    public <T> T assertThat(ExpectedCondition<T> condition) {
        return assertThat(condition, TestData.timeout);
    }

    public <T> T assertThat(ExpectedCondition<T> condition, int timeout) {
        return new WebDriverWait(driver, timeout).until(condition);
    }
}
