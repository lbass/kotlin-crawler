package com.lbass.manpu.crawler.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler


@Configuration
class ThreadPoolTaskSchedulerConfig {

    @Bean
    fun threadPoolTaskScheduler() : ThreadPoolTaskScheduler {
        val threadScheduler = ThreadPoolTaskScheduler()
        threadScheduler.poolSize = 4
        return threadScheduler
    }

}