package config

import org.aeonbits.owner.ConfigFactory

class ConfigReader {
    companion object {
        val emulatorConfig: EmulatorConfig by lazy {
            ConfigFactory.create(EmulatorConfig::class.java, System.getProperties())
        }
    }
}
