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
    fun getRegulationAll(): HashMap<String, ArrayList<String>> {
        return regulationService.getRegulationAll()
    }

    @GetMapping("/updated")
    fun getUpdated(): ArrayList<String> {
        return regulationService.getUpdatedCardNames()
    }

    @GetMapping("/forbidden")
    fun getForbidden(): ArrayList<String> {
        return regulationService.getForbiddenCardNames()
    }

    @GetMapping("/limited")
    fun getLimited(): ArrayList<String> {
        return regulationService.getLimitedCardNames()
    }

    @GetMapping("/semi")
    fun getSemiLimited(): ArrayList<String> {
        return regulationService.getSemiCardNames()
    }

    @GetMapping("/released")
    fun getReleased(): ArrayList<String> {
        return regulationService.getReleasedCardNames()
    }

}
