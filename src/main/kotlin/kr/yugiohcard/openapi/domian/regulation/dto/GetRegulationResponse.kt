package kr.yugiohcard.openapi.domian.regulation.dto

import io.swagger.v3.oas.annotations.media.Schema

data class GetRegulationResponse (
    @Schema(description = "파라미터에 따른 금제 리스트", example = "[\n" +
            "  \"EM 멍키보드\",\n" +
            "  \"M.X－세이버 인보커\"]")
    val cardList: ArrayList<String>,
)