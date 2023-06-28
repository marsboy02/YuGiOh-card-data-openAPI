package kr.yugiohcard.openapi.domian.regulation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @GetMapping("/{type}")
    fun getRegulation(@PathVariable type: String): ArrayList<String> {
        return regulationService.getRegulation(type)
    }
}
