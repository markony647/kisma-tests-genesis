package com.kismia.genesis.pages;

import com.kismia.genesis.concise_api.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class DatingPage {

    private WebDriver driver;
    private ConciseAPI conciseAPI;
    private By startGameBtn = By.cssSelector(".matches-game-carousel__elem-blocked .button-FR");
    private HashMap<Language, String> translations;

    public DatingPage(WebDriver driver) {
        this.driver = driver;
        conciseAPI = new ConciseAPI(driver);
    }

    public void assertCurrentLangIs(Language lang) {
        String text = getTabTranslations().get(lang);
        conciseAPI.assertThat(textToBe(startGameBtn, text));
    }

    // Add please other translations if you need to test a language except Russian
    private HashMap<Language, String> getTabTranslations() {
        translations = new HashMap<Language, String>();
        translations.put(Language.ru, "Начать игру");
        return translations;
    }
}
