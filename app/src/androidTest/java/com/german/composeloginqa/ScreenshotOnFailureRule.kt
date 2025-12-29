package com.german.composeloginqa

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import com.german.composeloginqa.ScreenshotUtil
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class ScreenshotOnFailureRule(
    private val rule: ComposeContentTestRule
) : TestWatcher() {

    override fun failed(e: Throwable?, description: Description) {
        ScreenshotUtil.takeScreenshot(
            rule = rule,
            testName = description.methodName
        )
    }
}