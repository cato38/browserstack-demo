package com.browserstack.demo;

import org.testng.annotations.Test;

public class StackTest extends BaseTest {

    @Test
    public void testClickApplyNow() {
        mainPage.clickApplyNow();
    }
}
