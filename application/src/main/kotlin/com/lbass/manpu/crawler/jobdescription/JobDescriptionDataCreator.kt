package com.lbass.manpu.crawler.jobdescription

import com.lbass.manpu.crawler.jobdescription.scraper.JobDescriptionScrapData
import com.lbass.manpu.crawler.utils.loggerFor
import org.springframework.stereotype.Component

@Component
class JobDescriptionDataCreator {
    private val log = loggerFor(javaClass)

    fun createJobDescriptions(jobDescriptionScrapData: List<JobDescriptionScrapData>) {
        log.info("$jobDescriptionScrapData")
    }
}