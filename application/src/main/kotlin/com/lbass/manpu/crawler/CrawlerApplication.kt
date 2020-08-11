package com.lbass.manpu.crawler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class CrawlerApplication

fun main(args: Array<String>) {
    // args 앞에 * 이 붙은 이유는 args 자체를 전달하는 것이 아니라 args 를 객체의 나열로 변환해서 전달하기 위해 처리
    runApplication<CrawlerApplication>(*args)
}

