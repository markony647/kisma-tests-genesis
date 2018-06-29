package com.kismia.genesis.pages;

import com.kismia.genesis.concise_api.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class PersonalSettingsPage {

    private WebDriver driver;
    private ConciseAPI conciseAPI;

    private By logoutLink = By.cssSelector(".new-header-subs [href='/sign/out']");

    public PersonalSettingsPage(WebDriver driver) {
        this.driver = driver;
        conciseAPI = new ConciseAPI(driver);
    }

    public void open() {
        driver.findElement(By.cssSelector(".new-header__photo img")).click();
    }

    public void logout() {
        open();
        conciseAPI.assertThat(elementToBeClickable(logoutLink)).click();
    }
}
