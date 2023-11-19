package kr.yugiohcard.openapi.domian.regulation.dto

import io.swagger.v3.oas.annotations.media.Schema

data class GetAllRegulationResponse (
    @Schema(description = "OCG 금제 리스트가 바뀐 카드들", example = "[\"후완다리즈와 의문의 지도 제한 ⇒ 준제한 제한 ⇒ 준제한\",\n" +
            "    \"군웅할거 신규 / 준제한 신규 / 준제한\"]")
    val update: ArrayList<String>,
    @Schema(description = "금지 카드 리스트", example = "[\"BF－농그림자의 고우후우\",\n" +
            "    \"Em 히구루미\"]")
    val forbidden: ArrayList<String>,
    @Schema(description = "제한 카드 리스트", example = "[\"EM 멍키보드\",\n" +
            "    \"M.X－세이버 인보커\"]")
    val limited: ArrayList<String>,
    @Schema(description = "준제한 카드 리스트", example = "[\"무덤의 지명자\",\n" +
            "    \"번개\"]")
    val semiLimited: ArrayList<String>,
    @Schema(description = "제한이 해제된 카드 리스트", example = "[ \"종말의 기사 준제한 ⇒ 해제 준제한 ⇒ 해제\",\n" +
            "    \"초중무사 바이－Q 준제한 ⇒ 해제 준제한 ⇒ 해제\"]")
    val releaseOfRestricted: ArrayList<String>,
)