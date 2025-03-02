package config

import org.aeonbits.owner.ConfigFactory

class EmulatorConfigReader {
    companion object {
        val emulatorConfig: EmulatorConfig by lazy {
            ConfigFactory.create(EmulatorConfig::class.java, System.getProperties())
        }
    }
}
