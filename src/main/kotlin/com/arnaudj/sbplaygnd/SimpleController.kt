package com.arnaudj.sbplaygnd

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class SimpleController {

    @GetMapping("/")
    @ResponseBody
    fun home(model: Model): String {
        return "hi!"
    }
}