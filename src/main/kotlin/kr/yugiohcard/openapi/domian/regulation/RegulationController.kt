package kr.yugiohcard.openapi.domian.regulation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/regulation")
class RegulationController(
    val regulationService: RegulationService,
) {
    @GetMapping
    fun getRegulationAll(): Any {
        return regulationService.getRegulationAll()
    }

    @GetMapping("/updated")
    fun getUpdated(): Any {
        return regulationService.getUpdatedCardNames()
    }

    @GetMapping("/forbidden")
    fun getForbidden(): Any {
        return regulationService.getForbiddenCardNames()
    }

    @GetMapping("/limited")
    fun getLimited(): Any {
        return regulationService.getLimitedCardNames()
    }

    @GetMapping("/semi")
    fun getSemiLimited(): Any {
        return regulationService.getSemiCardNames()
    }

    @GetMapping("/released")
    fun getReleased(): Any {
        return regulationService.getReleasedCardNames()
    }

}
