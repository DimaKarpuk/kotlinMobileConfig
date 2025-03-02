package driver

import com.codeborne.selenide.WebDriverProvider
import config.EmulatorConfig
import config.RealMobileConfig
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.aeonbits.owner.ConfigFactory
import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import java.io.File
import java.net.MalformedURLException
import java.net.URL
import javax.annotation.Nonnull

class RealMobileDriver: WebDriverProvider {
    companion object {
        private val localDevice: RealMobileConfig = ConfigFactory.create(
            RealMobileConfig::class.java,
            System.getProperties()
        )

        @JvmStatic
        fun getAppiumServerUrl(): URL {
            return try {
                URL(localDevice.mobileUrl())
            } catch (e: MalformedURLException) {
                throw RuntimeException(e)
            }
        }

        @JvmStatic
        private fun getAppPath(): String {
            val appVersion = "ozby.apk"
            val appPath = "src/test/resources/app/$appVersion"

            val app = File(appPath)
            if (!app.exists()) {
                throw AssertionError("Application file not found at $appPath")
            }
            return app.absolutePath
        }
    }

    @Nonnull
    override fun createDriver(@Nonnull capabilities: Capabilities): WebDriver {
        return getLocalDriver()
    }

    fun getLocalDriver(): AndroidDriver {
        val options = UiAutomator2Options()
        options.setAutomationName("UiAutomator2")
            .setPlatformName("Android")
            .setPlatformVersion(localDevice.platformVersion())
            .setDeviceName(localDevice.deviceName())
            .setApp(getAppPath())
            .setAppPackage(localDevice.appPackage())
            .setAppActivity(localDevice.appActivity())

        return AndroidDriver(getAppiumServerUrl(), options)
    }
}