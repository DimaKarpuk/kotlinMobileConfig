package tests

import com.codeborne.selenide.Selenide.*
import io.appium.java_client.AppiumBy.className
import io.appium.java_client.AppiumBy.id
import org.junit.jupiter.api.Test

class Tests : TestBase() {
    @Test
    fun simpleTest(){
        `$`(id("android:id/button2")).click()
        `$`(className("android.widget.ImageButton")).click()
    }
}