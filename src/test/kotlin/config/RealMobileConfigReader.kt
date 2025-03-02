package config

import org.aeonbits.owner.ConfigFactory

class RealMobileConfigReader {
    companion object {
        val realMobileConfig: RealMobileConfig by lazy {
            ConfigFactory.create(RealMobileConfig::class.java, System.getProperties())
        }
    }
}