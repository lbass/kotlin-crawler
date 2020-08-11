package com.lbass.manpu.crawler.jobdescription.scraper

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.lbass.manpu.crawler.utils.loggerFor
import org.springframework.stereotype.Component

@Component
class JobKoreaPageParser {

    private val log = loggerFor(javaClass)

    fun getJobDescriptions(jsonData: String): List<JobDescriptionScrapData> {
        val mapper = jacksonObjectMapper()
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        val converted : JobKoreaMainRecruitingPage = mapper.readValue(jsonData)
        return converted.distinctAllItem
            .map { JobDescriptionScrapData(it.corpName, it.giTitle) }
            .toList()
    }
}