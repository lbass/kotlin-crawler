package com.lbass.manpu.crawler

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.lbass.manpu.crawler.jobdescription.scraper.JobKoreaMainRecruitingPage
import org.junit.jupiter.api.Test
import java.net.URL

class JobKoreaPageParserTest {

    @Test
    fun testJobKoreaPageParser() {
        val mapper = jacksonObjectMapper()
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        val converted : JobKoreaMainRecruitingPage = mapper.readValue(URL("file:src/test/resources/json-example/jobkoreaJsonData.json"))
        converted.distinctAllItem.forEach { println("${it.corpName}, ${it.giTitle}") }
    }
}

