package com.lbass.manpu.crawler.schedule

import com.lbass.manpu.crawler.utils.loggerFor
import com.lbass.manpu.crawler.jobdescription.JobDescriptionCollector
import com.lbass.manpu.crawler.jobdescription.RecruitingSite
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled

@Configuration
class CollectionSchedule(private val jobDescriptionCollector: JobDescriptionCollector) {
    private val log = loggerFor(javaClass)

    // 30분 단위로 실행
    @Scheduled(initialDelay = 0, fixedDelay = 1000 * 60 * 60)
    fun collectJobKoreaJobDescription() {
        log.info("JobKorea")
        jobDescriptionCollector.collect(RecruitingSite.JOBKOREA);
    }

    // 30분 단위로 실행
    @Scheduled(initialDelay = 0, fixedDelay = 1000 * 5)
    fun collectSaraminJobDescription() {
        log.info("Saramin")
        // jobDescriptionCollector.collect(RecruitingSite.SARAMIN);
    }
}