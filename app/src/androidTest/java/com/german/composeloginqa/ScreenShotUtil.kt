package com.german.composeloginqa


import android.graphics.Bitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onRoot
import java.io.File
import java.io.FileOutputStream

object ScreenshotUtil {

    fun takeScreenshot(
        rule: ComposeContentTestRule,
        testName: String
    ) {
        val bitmap: Bitmap = rule
            .onRoot()
            .captureToImage()
            .asAndroidBitmap()

        val dir = File("/sdcard/compose_screenshots")

        if (!dir.exists()) {
            dir.mkdirs()
        }

        val file = File(dir, "$testName.png")

        FileOutputStream(file).use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
        }
    }
}

