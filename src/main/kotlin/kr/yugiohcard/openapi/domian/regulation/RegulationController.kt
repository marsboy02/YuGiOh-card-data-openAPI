package kr.yugiohcard.openapi.domian.regulation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import kr.yugiohcard.openapi.domian.regulation.dto.GetAllRegulationResponse
import kr.yugiohcard.openapi.domian.regulation.dto.GetRegulationResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/regulation")
@Tag(name = "Limit Regulation", description = "리미트 레귤레이션 정보를 반환합니다.")
class RegulationController(
    val regulationService: RegulationService,
) {
    @GetMapping
    @Operation(summary = "리미트 레귤레이션의 모든 정보 확인", description = "OCG 리미트 레귤레이션의 모든 정보를 반환합니다.")
    fun getRegulationAll(): GetAllRegulationResponse {
        return regulationService.getRegulationAll()
    }

    @GetMapping("/{type}")
    @Operation(summary = "리미트 레귤레이션의 정보 확인", description = "path에 해당하는 리미트 레귤레이션 정보를 반환합니다.")
    fun getRegulation(@PathVariable type: String): GetRegulationResponse {
        return regulationService.getRegulation(type)
    }
}
