package com.german.composeloginqa

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import pages.LoginScreenPage

@RunWith(AndroidJUnit4::class)
class MultipleLoginTestScenarios {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @get:Rule
    val screenshotRule = ScreenshotOnFailureRule(composeRule)

    private val loginPage by lazy {
        LoginScreenPage(composeRule)
    }

    @Test
    fun login_withInvalidCredentials_showsErrorMessage() {
        LoginTestDataset.invalidCredentials.forEach { data ->

            // WHEN
            loginPage.loginAs(data.username, data.password)

            // THEN
            loginPage.assertInvalidCredentialsError()
        }
    }
}
