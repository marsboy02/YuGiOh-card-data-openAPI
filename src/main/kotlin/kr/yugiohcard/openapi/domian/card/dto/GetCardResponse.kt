package kr.yugiohcard.openapi.domian.card.dto

data class GetCardResponse(
    val cardName: String?,
    val cardAttr: String?,
    val cardLevel: String?,
    val cardOther: String?,
    val cardAtk: String?,
    val cardDef: String?,
    val cardText: String?,
)
