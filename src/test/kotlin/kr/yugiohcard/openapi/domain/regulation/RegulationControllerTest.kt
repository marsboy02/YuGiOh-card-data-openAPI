package kr.yugiohcard.openapi.domain.regulation

import kr.yugiohcard.openapi.domian.card.CardController
import kr.yugiohcard.openapi.domian.regulation.RegulationController
import kr.yugiohcard.openapi.domian.regulation.RegulationService
import kr.yugiohcard.openapi.domian.regulation.dto.GetRegulationResponse
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@ExtendWith(SpringExtension::class)
@WebMvcTest(RegulationController::class)
class RegulationControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var regulationService: RegulationService

    @Test
    fun `업데이트된 카드들의 정보를 정상적으로 반환한다`() {
        val mockResponse = GetRegulationResponse(ArrayList<String>())

        `when`(regulationService.getRegulation("update")).thenReturn(mockResponse)

        mockMvc.perform(get("/regulation/update").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.cardList").exists())
    }

    @Test
    fun `금지된 카드들의 정보를 정상적으로 반환환다`() {
        val mockResponse = GetRegulationResponse(ArrayList<String>())

        `when`(regulationService.getRegulation("forbidden")).thenReturn(mockResponse)

        mockMvc.perform(get("/regulation/forbidden").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.cardList").exists())
    }

    @Test
    fun `제한된 카드들의 정보를 정상적으로 반환한다`() {
        val mockResponse = GetRegulationResponse(ArrayList<String>())

        `when`(regulationService.getRegulation("limited")).thenReturn(mockResponse)

        mockMvc.perform(get("/regulation/limited").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.cardList").exists())
    }

    @Test
    fun `준제한된 카드들의 정보를 정상적으로 반환한다`() {
        val mockResponse = GetRegulationResponse(ArrayList<String>())

        `when`(regulationService.getRegulation("semi_limited")).thenReturn(mockResponse)

        mockMvc.perform(get("/regulation/semi_limited").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.cardList").exists())
    }

    @Test
    fun `제한이 해제된 카드들의 정보를 정상적으로 반환한다`() {
        val mockResponse = GetRegulationResponse(ArrayList<String>())

        `when`(regulationService.getRegulation("release_of_restricted")).thenReturn(mockResponse)

        mockMvc.perform(get("/regulation/release_of_restricted").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.cardList").exists())
    }
}