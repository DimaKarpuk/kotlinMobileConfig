package config

import org.aeonbits.owner.Config
import org.aeonbits.owner.Config.Key

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(
    "system:properties",
    "file:src/test/resources/configs/emulator.properties",
)
interface EmulatorConfig : Config {
    @Key("deviceName")
    fun deviceName(): String

    @Key("platformVersion")
    fun platformVersion(): String

    @Key("appPackage")
    fun appPackage(): String

    @Key("appActivity")
    fun appActivity(): String

    @Key("app")
    fun app(): String

    @Key("mobileUrl")
    fun mobileUrl(): String
}