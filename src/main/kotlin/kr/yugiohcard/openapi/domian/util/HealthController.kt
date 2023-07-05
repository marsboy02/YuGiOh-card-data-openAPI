package kr.yugiohcard.openapi.domian.util

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping
@Tag(name = "Health Check", description = "서비스의 상태를 확인합니다.")
class HealthController {
    @GetMapping
    @Operation(summary = "서비스의 상태를 체크합니다.", description = "LocalDate를 반환합니다.")
    fun getHealth(): String {
        val onlyDate: String = LocalDate.now().toString()
        return "Current date : $onlyDate"
    }
}
