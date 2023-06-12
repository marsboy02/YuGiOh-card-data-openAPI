package kr.yugiohcard.openapi.domian.regulation

import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class RegulationService {
    final val url = "https://www.db.yugioh-card.com/yugiohdb/forbidden_limited.action"
    val doc = Jsoup.connect(url).header("Accept-Language", "ko").get()

    fun getRegulationAll(): Any {
        val allRegulation = HashMap<String, ArrayList<String>>()
        allRegulation.put("update", crawlingByCss("update"))
        allRegulation.put("forbidden", crawlingByCss("forbidden"))
        allRegulation.put("limited", crawlingByCss("limited"))
        allRegulation.put("semiLimited", crawlingByCss("semi_limited"))
        allRegulation.put("releaseOfRestricted", crawlingByCss("release_of_restricted"))
        return allRegulation
    }
    fun getUpdatedCardNames(): Any {
        return crawlingByCss("update")
    }
    fun getForbiddenCardNames(): Any {
        return crawlingByCss("forbidden")
    }

    fun getLimitedCardNames(): Any {
        return crawlingByCss("limited")
    }

    fun getSemiCardNames(): Any {
        return crawlingByCss("semi_limited")
    }

    fun getReleasedCardNames(): Any {
        return crawlingByCss("release_of_restricted")
    }

    private fun crawlingByCss(id: String): ArrayList<String> {
        val elements = doc.select("#list_$id > div.list > div > div")
        val allCardName = arrayListOf<String>()
        for (element in elements) {
            allCardName.add(element.text())
        }
        return allCardName
    }
}
