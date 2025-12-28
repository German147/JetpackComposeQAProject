package pages

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithTag

abstract class BasePage(protected open val rule: ComposeContentTestRule){

    protected fun waitForNodeWithTag(tag: String, timeoutMillis: Long = 3_000){
            rule.waitUntil (timeoutMillis){
                rule.onAllNodesWithTag(tag).fetchSemanticsNodes().isNotEmpty()
            }
    }

}