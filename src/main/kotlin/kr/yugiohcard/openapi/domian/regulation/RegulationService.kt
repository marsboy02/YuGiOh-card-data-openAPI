package kr.yugiohcard.openapi.domian.regulation

import kr.yugiohcard.openapi.domian.regulation.dto.GetAllRegulationResponse
import kr.yugiohcard.openapi.domian.regulation.dto.GetRegulationResponse
import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class RegulationService {
    private final val url = "https://www.db.yugioh-card.com/yugiohdb/forbidden_limited.action"
    val doc = Jsoup.connect(url).header("Accept-Language", "ko").get()

    fun getRegulationAll(): GetAllRegulationResponse {
        val update = crawlingByCss("update")
        val forbidden = crawlingByCss("forbidden")
        val limited = crawlingByCss("limited")
        val semiLimited= crawlingByCss("semi_limited")
        val releaseOfRestricted = crawlingByCss("release_of_restricted")
        return GetAllRegulationResponse(update, forbidden, limited, semiLimited, releaseOfRestricted)
    }

    fun getRegulation(type: String): GetRegulationResponse {
        return GetRegulationResponse(crawlingByCss(type))
    }

    private fun crawlingByCss(id: String): ArrayList<String> {
        val elements = doc.select("#list_$id > div.list > div > div")
        val allCardName = arrayListOf<String>()
        for (element in elements) allCardName.add(element.text())
        return allCardName
    }
}
