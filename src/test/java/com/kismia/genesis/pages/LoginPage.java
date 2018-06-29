package com.kismia.genesis.pages;

import com.kismia.genesis.concise_api.ConciseAPI;
import com.kismia.genesis.tests.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class LoginPage {

    private WebDriver driver;
    private ConciseAPI conciseAPI;
    private By loginButton = By.cssSelector(".js_signInForm .js_submit");
    private By emailField = By.cssSelector(".js_signInForm [name=email]");
    private By passwordField = By.cssSelector(".js_signInForm [name=password]");
    private HashMap<Language, String> translations;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void visit() {
        driver.get(TestData.baseUrl);
        conciseAPI = new ConciseAPI(driver);
    }

    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void setLanguage(Language lang) {
        driver.findElement(By.className("js_showLanguagesList")).click();
        driver.findElement(conciseAPI.findByText(lang.toString())).click();
    }

    public void assertCurrentLangIs(Language lang) {
        String title = getTabTranslations().get(lang);
        conciseAPI.assertThat(titleContains(title));
    }

    private HashMap<Language, String> getTabTranslations() {
        translations = new HashMap<Language, String>();
        translations.put(Language.ru, "Сайт знакомств kismia - серьезные интернет знакомства в России и СНГ: Kismia");
        translations.put(Language.en, "kismia is international online dating site with 26 million active users.: Kismia");
        translations.put(Language.fr, "kismia est un site international de rencontres en ligne avec plus de 26 millions d'utilisateurs actifs.: Kismia");
        translations.put(Language.es, "kismia es un sitio internacional de citas en línea con 26 millones de usuarios activos.: Kismia");
        translations.put(Language.pt, "kismia é um site internacional de encontros on-line com 26 milhões de usuários ativos.: Kismia");
        return translations;
    }


}
