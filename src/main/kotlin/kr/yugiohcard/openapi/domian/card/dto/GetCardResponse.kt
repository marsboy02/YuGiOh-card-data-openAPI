package kr.yugiohcard.openapi.domian.card.dto

import io.swagger.v3.oas.annotations.media.Schema

data class GetCardResponse(
    @Schema(description = "카드명", example = "하루 우라라")
    val cardName: String?,
    @Schema(description = "속성", example = "화염")
    val cardAttr: String?,
    @Schema(description = "레벨", example = "레벨 3")
    val cardLevel: String?,
    @Schema(description = "종족 및 타입", example = "[ 언데드족 / 튜너 / 효과 ]")
    val cardOther: String?,
    @Schema(description = "공격력", example = "공격력 0")
    val cardAtk: String?,
    @Schema(description = "수비력", example = "수비력 1800")
    val cardDef: String?,
    @Schema(description = "효과 설명", example = "이 카드명의 효과는 1턴에 1번밖에 사용할 수 없다. .. (중략)")
    val cardText: String?,
)
