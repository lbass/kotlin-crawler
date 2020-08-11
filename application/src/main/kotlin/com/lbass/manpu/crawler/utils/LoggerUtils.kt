package com.lbass.manpu.crawler.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun <T> loggerFor(clazz: Class<T>): Logger = LoggerFactory.getLogger(clazz)
fun loggerFor(name: String = "NO-NAME"): Logger = LoggerFactory.getLogger(name)