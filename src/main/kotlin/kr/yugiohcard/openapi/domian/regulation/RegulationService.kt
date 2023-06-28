package kr.yugiohcard.openapi.domian.regulation

import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class RegulationService {
    private final val url = "https://www.db.yugioh-card.com/yugiohdb/forbidden_limited.action"
    val doc = Jsoup.connect(url).header("Accept-Language", "ko").get()

    fun getRegulationAll(): HashMap<String, ArrayList<String>> {
        val allRegulation = HashMap<String, ArrayList<String>>()
        allRegulation["update"] = crawlingByCss("update")
        allRegulation["forbidden"] = crawlingByCss("forbidden")
        allRegulation["limited"] = crawlingByCss("limited")
        allRegulation["semiLimited"] = crawlingByCss("semi_limited")
        allRegulation["releaseOfRestricted"] = crawlingByCss("release_of_restricted")
        return allRegulation
    }

    fun getRegulation(type: String): ArrayList<String> {
        return crawlingByCss(type)
    }

    private fun crawlingByCss(id: String): ArrayList<String> {
        val elements = doc.select("#list_$id > div.list > div > div")
        val allCardName = arrayListOf<String>()
        for (element in elements) allCardName.add(element.text())
        return allCardName
    }
}
