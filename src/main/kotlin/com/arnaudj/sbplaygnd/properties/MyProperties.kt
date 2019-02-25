package com.arnaudj.sbplaygnd.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "myproperties")
class MyProperties {

    lateinit var appTitle: String
    val banner = Banner()

    class Banner {
        var title: String? = null
    }
}