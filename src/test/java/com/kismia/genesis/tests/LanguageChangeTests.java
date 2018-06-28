package com.kismia.genesis.tests;

import com.kismia.genesis.pages.Language;
import org.testng.annotations.Test;

public class LanguageChangeTests extends TestBase {

    @Test
    public void testChangeLanguageAtLogin() {
        app.loginPage.visit();
        app.loginPage.assertCurrentLangIs(Language.ru);
        app.loginPage.setLanguage(Language.en);
        app.loginPage.assertCurrentLangIs(Language.en);
        app.loginPage.login(TestData.email, TestData.password);
        app.datingPage.assertCurrentLangIs(Language.ru);
        app.personalSettingsPage.logout();
        app.loginPage.assertCurrentLangIs(Language.ru);
    }
}
