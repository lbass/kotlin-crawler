package com.lbass.manpu.crawler.jobdescription.scraper

import com.lbass.manpu.crawler.jobdescription.RecruitingSite

interface JobDescriptionScraper {
    val site: RecruitingSite
    fun scrapJobDescription() : List<JobDescriptionScrapData>

}
