package tests

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import com.codeborne.selenide.Selenide.*
import driver.RealMobileDriver
import helper.EmulatorDriver
import io.appium.java_client.AppiumBy.id

open class TestBase {
    companion object {

        @JvmStatic
        @BeforeAll
        fun beforeAll() {
            Configuration.browserSize = null
            Configuration.timeout = 30000
           // Configuration.browser = EmulatorDriver::class.java.name
            Configuration.browser = RealMobileDriver::class.java.name
        }
    }

    @BeforeEach
    fun beforeEach() {
        SelenideLogger.addListener("AllureSelenide", AllureSelenide())
        open()
        `$`(id("android:id/button2")).click()
    }
}

