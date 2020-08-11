package com.lbass.manpu.crawler.jobdescription.scraper

import com.fasterxml.jackson.annotation.JsonProperty

data class JobKoreaMainRecruitingPage(
    private val newItems: List<JobKoreaJobItem> = emptyList(),
    private val recmItems: List<JobKoreaJobItem> = emptyList(),
    // 오타로 인한
    @JsonProperty("additionaltems") private val additionalItems: List<JobKoreaJobItem> = emptyList()
) {
    val distinctAllItem : List<JobKoreaJobItem>
        get() = listOf(*this.additionalItems.toTypedArray(),
            *this.newItems.toTypedArray(),
            *this.recmItems.toTypedArray()).
        asSequence().
        distinctBy { it.gno }.
        toList()
}

data class JobKoreaJobItem (
    val corpName : String = "",
    val gno: Long = 0,
    val giTitle: String ="",
    val workLocal: String = ""
)
