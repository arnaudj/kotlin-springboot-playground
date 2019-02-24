package com.arnaudj.sbplaygnd.controllers

import java.lang.RuntimeException

class ElementNotFoundException(message: String) : RuntimeException("Could not find $message")