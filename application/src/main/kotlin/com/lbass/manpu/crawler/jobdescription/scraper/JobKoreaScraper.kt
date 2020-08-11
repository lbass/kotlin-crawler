package com.lbass.manpu.crawler.jobdescription.scraper

import com.lbass.manpu.crawler.jobdescription.RecruitingSite
import com.lbass.manpu.crawler.utils.JsoupMethod
import com.lbass.manpu.crawler.utils.loggerFor
import com.lbass.manpu.crawler.utils.scrapFromUrl
import org.springframework.stereotype.Component

const val JOBKOREA_HOME = "http://www.jobkorea.co.kr/SmartMatch/GetMainRecruits"

@Component
class JobKoreaScraper(private val jobKoreaPageParser : JobKoreaPageParser) : JobDescriptionScraper {

    private val log = loggerFor(javaClass)
    override val site: RecruitingSite
        get() = RecruitingSite.JOBKOREA

    override fun scrapJobDescription(): List<JobDescriptionScrapData> {
        val jsonData = scrapFromUrl(JOBKOREA_HOME, JsoupMethod.POST) { it.body().text() }
        return if (jsonData is String) jobKoreaPageParser.getJobDescriptions(jsonData)
        else emptyList()
    }
}