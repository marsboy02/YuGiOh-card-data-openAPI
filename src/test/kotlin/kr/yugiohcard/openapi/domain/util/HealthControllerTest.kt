package kr.yugiohcard.openapi.domain.util

import kr.yugiohcard.openapi.domian.util.HealthController
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.time.LocalDate


@ExtendWith(SpringExtension::class)
@WebMvcTest(HealthController::class)
class HealthControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `디폴트 url에서는 health check 메시지를 반환한다`() {
        val expectedDate = LocalDate.now().toString()
        mockMvc.perform(get("/"))
            .andExpect(status().isOk)
            .andExpect(content().string("Current date : $expectedDate"))
    }
}