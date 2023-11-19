package kr.yugiohcard.openapi.domian.card

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import kr.yugiohcard.openapi.domian.card.dto.GetCardResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/card")
@Tag(name = "Card", description = "카드의 정보를 반환합니다.")
class CardController(
    val cardService: CardService,
) {
    @GetMapping("{name}")
    @Operation(summary = "카드의 정보를 반환합니다.", description = "카드의 정보를 반환합니다.")
    fun getCardData(@PathVariable name: String): GetCardResponse {
        return cardService.getCardData(name)
    }
}
