package com.lbass.manpu.crawler.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

enum class JsoupMethod {
    GET,
    POST
}

private val log = loggerFor("JsoupHelper")

fun scrapFromUrl(
    url: String,
    method: JsoupMethod = JsoupMethod.GET,
    headers: Map<String, String> = emptyMap(),
    params: Map<String, String> = emptyMap(),
    mapper: (d: Document) -> Any = { it }
): Any {
    val conn: Connection = Jsoup.connect(url)
        .headers(headers)
        .timeout(5_000)
        .ignoreContentType(true)
        .data(params)
    val result : Document = if (method == JsoupMethod.GET) conn.get() else conn.post()
    return mapper(result)
}
