package kr.yugiohcard.openapi.domian.card

import kr.yugiohcard.openapi.domian.card.dto.GetCardResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/card")
class CardController(
    val cardService: CardService,
) {
    @GetMapping("{name}")
    fun getCardData(@PathVariable name: String): GetCardResponse {
        return cardService.getCardData(name)
    }
}
