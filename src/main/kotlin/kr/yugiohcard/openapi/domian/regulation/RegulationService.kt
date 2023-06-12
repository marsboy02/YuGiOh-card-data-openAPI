package kr.yugiohcard.openapi.domian.regulation

import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class RegulationService {
    final val url = "https://www.db.yugioh-card.com/yugiohdb/forbidden_limited.action"
    val doc = Jsoup.connect(url).header("Accept-Language", "ko").get()

    fun getRegulationAll(): HashMap<String, ArrayList<String>> {
        val allRegulation = HashMap<String, ArrayList<String>>()
        allRegulation.put("update", crawlingByCss("update"))
        allRegulation.put("forbidden", crawlingByCss("forbidden"))
        allRegulation.put("limited", crawlingByCss("limited"))
        allRegulation.put("semiLimited", crawlingByCss("semi_limited"))
        allRegulation.put("releaseOfRestricted", crawlingByCss("release_of_restricted"))
        return allRegulation
    }
    fun getUpdatedCardNames(): ArrayList<String> {
        return crawlingByCss("update")
    }
    fun getForbiddenCardNames(): ArrayList<String> {
        return crawlingByCss("forbidden")
    }

    fun getLimitedCardNames(): ArrayList<String> {
        return crawlingByCss("limited")
    }

    fun getSemiCardNames(): ArrayList<String> {
        return crawlingByCss("semi_limited")
    }

    fun getReleasedCardNames(): ArrayList<String> {
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
