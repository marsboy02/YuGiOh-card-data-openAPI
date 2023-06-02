package kr.yugiohcard.openapi.domian.card

import kr.yugiohcard.openapi.domian.card.dto.GetCardResponse
import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class CardService {
    val url = "https://www.db.yugioh-card.com/yugiohdb/card_search.action?ope=1&keyword="

    fun getCardData(name: String): GetCardResponse {
        val fullUrl = url + name
        return crawlingByUrl(fullUrl)
    }

    private fun crawlingByUrl(url: String): GetCardResponse {
        val doc = Jsoup.connect(url).header("Accept-Language", "ko").get()
        val name = doc.selectFirst("#card_list > div > dl > dd.box_card_name.flex_1.top_set > span.card_name")?.text()
        val attr = doc.selectFirst("#card_list > div > dl > dd.box_card_spec.flex_1 > span.box_card_attribute")?.text()
        val level = doc.selectFirst("#card_list > div > dl > dd.box_card_spec.flex_1 > span.box_card_level_rank.level")?.text()
        val other = doc.selectFirst("#card_list > div > dl > dd.box_card_spec.flex_1 > span.card_info_species_and_other_item")?.text()
        val atk = doc.selectFirst("#card_list > div > dl > dd.box_card_spec.flex_1 > span.atk_power")?.text()
        val def = doc.selectFirst("#card_list > div > dl > dd.box_card_spec.flex_1 > span.def_power")?.text()
        val text = doc.selectFirst("#card_list > div > dl > dd.box_card_text.c_text.flex_1")?.text()

        return GetCardResponse(name, attr, level, other, atk, def, text)
    }
}
