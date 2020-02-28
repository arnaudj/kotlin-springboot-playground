package com.arnaudj.sbplaygnd

import com.arnaudj.sbplaygnd.properties.MyProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ConfigService {
    @Autowired
    lateinit var myProperties: MyProperties

    fun getInitInfoMessage() = "Init app: ${myProperties.appTitle} - ${myProperties.banner.title}"
}