package com.lbass.manpu.crawler.jobdescription

import com.lbass.manpu.crawler.jobdescription.scraper.JobDescriptionScrapData
import com.lbass.manpu.crawler.jobdescription.scraper.JobDescriptionScraper
import org.springframework.stereotype.Service

@Service
class JobDescriptionCollector(private var scrapers : List<JobDescriptionScraper>,
                              private var jobDescriptionDataCreator : JobDescriptionDataCreator
) {

    fun collect(site: RecruitingSite) {
        val jobDescriptionScrapData: List<JobDescriptionScrapData> = this.scrapers
            .first { it.site == site }
            .scrapJobDescription()
        this.jobDescriptionDataCreator.createJobDescriptions(jobDescriptionScrapData)
    }
}