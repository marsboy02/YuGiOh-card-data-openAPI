package kr.yugiohcard.openapi.domain.card

import kr.yugiohcard.openapi.domian.card.CardController
import kr.yugiohcard.openapi.domian.card.CardService
import kr.yugiohcard.openapi.domian.card.dto.GetCardResponse
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.MockMvc


@ExtendWith(SpringExtension::class)
@WebMvcTest(CardController::class)
class CardControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var cardService: CardService

    @Test
    fun `몬스터 카드에 대한 정보를 성공적으로 조회`() {
        val cardName = "하루 우라라"
        val cardResponse = GetCardResponse(
            cardName = cardName,
            cardAttr = "화염",
            cardLevel = "레벨 3",
            cardOther = "[ 언데드족 / 튜너 / 효과 ]",
            cardAtk = "공격력 0",
            cardDef = "수비력 1800",
            cardText = "이 카드명의 효과는 1턴에 1번밖에 사용할 수 없다. ①: 이하의 어느 효과를 포함하는 마법 / 함정 / 몬스터의 효과가 발동했을 때, 이 카드를 패에서 버리고 발동할 수 있다. 그 효과를 무효로 한다. ●덱에서 카드를 패에 넣는 효과 ●덱에서 몬스터를 특수 소환하는 효과 ●덱에서 카드를 묘지로 보내는 효과"
        )

        `when`(cardService.getCardData(anyString())).thenReturn(cardResponse)

        mockMvc.perform(get("/card/$cardName").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.cardName").value(cardName))
            .andExpect(jsonPath("$.cardAttr").value("화염"))
            .andExpect(jsonPath("$.cardLevel").value("레벨 3"))
            .andExpect(jsonPath("$.cardOther").value("[ 언데드족 / 튜너 / 효과 ]"))
            .andExpect(jsonPath("$.cardAtk").value("공격력 0"))
            .andExpect(jsonPath("$.cardDef").value("수비력 1800"))
            .andExpect(jsonPath("$.cardText").value("이 카드명의 효과는 1턴에 1번밖에 사용할 수 없다. ①: 이하의 어느 효과를 포함하는 마법 / 함정 / 몬스터의 효과가 발동했을 때, 이 카드를 패에서 버리고 발동할 수 있다. 그 효과를 무효로 한다. ●덱에서 카드를 패에 넣는 효과 ●덱에서 몬스터를 특수 소환하는 효과 ●덱에서 카드를 묘지로 보내는 효과"))
    }

    @Test
    fun `마법 카드에 대한 정보를 성공적으로 조회`() {
        val cardName = "소환사의 스킬"
        val cardResponse = GetCardResponse(
            cardName = cardName,
            cardAttr = "마법",
            cardLevel = null,
            cardOther = null,
            cardAtk = null,
            cardDef = null,
            cardText = "①: 덱에서 레벨 5 이상의 일반 몬스터 1장을 패에 넣는다."
        )

        `when`(cardService.getCardData(anyString())).thenReturn(cardResponse)

        mockMvc.perform(get("/card/$cardName").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.cardName").value(cardName))
            .andExpect(jsonPath("$.cardAttr").value("마법"))
            .andExpect(jsonPath("$.cardLevel").doesNotExist())
            .andExpect(jsonPath("$.cardOther").doesNotExist())
            .andExpect(jsonPath("$.cardAtk").doesNotExist())
            .andExpect(jsonPath("$.cardDef").doesNotExist())
            .andExpect(jsonPath("$.cardText").value("①: 덱에서 레벨 5 이상의 일반 몬스터 1장을 패에 넣는다."))
    }

    @Test
    fun `함정 카드에 대한 정보를 성공적으로 조회`() {
        val cardName = "격류장"
        val cardResponse = GetCardResponse(
            cardName = cardName,
            cardAttr = "함정",
            cardLevel = null,
            cardOther = null,
            cardAtk = null,
            cardDef = null,
            cardText = "①: 몬스터가 일반 소환 / 반전 소환 / 특수 소환되었을 때에 발동할 수 있다. 필드의 몬스터를 전부 파괴한다."
        )

        `when`(cardService.getCardData(anyString())).thenReturn(cardResponse)

        mockMvc.perform(get("/card/$cardName").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.cardName").value(cardName))
            .andExpect(jsonPath("$.cardAttr").value("함정"))
            .andExpect(jsonPath("$.cardLevel").doesNotExist())
            .andExpect(jsonPath("$.cardOther").doesNotExist())
            .andExpect(jsonPath("$.cardAtk").doesNotExist())
            .andExpect(jsonPath("$.cardDef").doesNotExist())
            .andExpect(jsonPath("$.cardText").value("①: 몬스터가 일반 소환 / 반전 소환 / 특수 소환되었을 때에 발동할 수 있다. 필드의 몬스터를 전부 파괴한다."))
    }
}