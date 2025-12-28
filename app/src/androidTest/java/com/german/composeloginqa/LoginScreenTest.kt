package com.german.composeloginqa

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun loginScreen_initialState() {
        composeTestRule.onNodeWithTag("username_input").assertIsDisplayed()
        composeTestRule.onNodeWithTag("password_input").assertIsDisplayed()
        composeTestRule.onNodeWithTag("login_button").assertIsDisplayed()
    }

    @Test
    fun login_withInvalidCredentials_showsError() {
        composeTestRule.onNodeWithTag("username_input")
            .performTextInput("wrong")

        composeTestRule.onNodeWithTag("password_input")
            .performTextInput("wrong")

        composeTestRule.onNodeWithTag("login_button")
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 3_000) {
            composeTestRule
                .onAllNodesWithTag("error_message")
                .fetchSemanticsNodes().isNotEmpty()
        }

        composeTestRule.onNodeWithTag("error_message")
            .assertTextContains("Invalid")
    }

    @Test
    fun login_withValidCredentials_navigatesToWelcome() {
        composeTestRule.onNodeWithTag("username_input")
            .performTextInput("admin")

        composeTestRule.onNodeWithTag("password_input")
            .performTextInput("1234")

        composeTestRule.onNodeWithTag("login_button")
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 3_000) {
            composeTestRule
                .onAllNodesWithTag("welcome_text")
                .fetchSemanticsNodes().isNotEmpty()
        }

        composeTestRule.onNodeWithTag("welcome_text")
            .assertIsDisplayed()
    }
}