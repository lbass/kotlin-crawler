package com.lbass.manpu.crawler.jobdescription.scraper

data class JobDescriptionScrapData(val corpName: String, val jobTitle: String) {
    override fun toString(): String {
        return "[회사명: $corpName| 포지션: $jobTitle] \n"
    }
}