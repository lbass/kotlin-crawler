package com.lbass.manpu.crawler.jobdescription.scraper

import com.lbass.manpu.crawler.jobdescription.RecruitingSite
import com.lbass.manpu.crawler.utils.loggerFor
import com.lbass.manpu.crawler.utils.scrapFromUrl
import org.springframework.stereotype.Component

@Component
class SaraminScraper : JobDescriptionScraper {

    private val log = loggerFor(javaClass)

    override val site: RecruitingSite
        get() = RecruitingSite.SARAMIN

    override fun scrapJobDescription(): List<JobDescriptionScrapData> {
        val document = scrapFromUrl("https://daum.net")
        log.info("$document")
        return listOf(
            JobDescriptionScrapData(
                "사람인 제목",
                "사람인 설명"
            )
        )
    }

}