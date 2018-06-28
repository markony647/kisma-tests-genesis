package com.kismia.genesis.tests;

import com.kismia.genesis.app.Application;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    public Application app;

    @BeforeTest
    public void setUp() {
        app = new Application();
    }

    @AfterTest
    public void tearDown() {
        app.quit();
    }
}
