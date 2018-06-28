package com.kismia.genesis.app;

import com.kismia.genesis.concise_api.ConciseAPI;
import com.kismia.genesis.pages.DatingPage;
import com.kismia.genesis.pages.LoginPage;
import com.kismia.genesis.pages.PersonalSettingsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {

    private WebDriver driver;
    public LoginPage loginPage;
    public DatingPage datingPage;
    public ConciseAPI conciseAPI;
    public PersonalSettingsPage personalSettingsPage;

    public Application() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        datingPage = new DatingPage(driver);
        personalSettingsPage = new PersonalSettingsPage(driver);
        conciseAPI = new ConciseAPI(driver);
    }

    public void quit() {
        driver.quit();
    }
}
