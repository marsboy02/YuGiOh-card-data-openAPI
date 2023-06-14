# YuGiOh-card-data-api

> 유희왕 카드 게임에 대한 정보를 제공하는 API입니다.

HTTP GET 요청을 통해 [유희왕 데이터베이스](https://www.db.yugioh-card.com/yugiohdb/?request_locale=ko)
에서 다양한 유희왕 정보를 JSON으로 응답받아 사용할 수 있습니다. 
모든 정보는 한국어로 제공됩니다.

## 카드 정보 확인

`https://yugiohcard.kr/card/{카드명}`

한글로 검색한 유희왕 카드의 정보를 반환합니다. 

### 응답

```JSON
{
  "cardName": "하루 우라라",
  "cardAttr": "화염",
  "cardLevel": "레벨 3",
  "cardOther": "[ 언데드족 / 튜너 / 효과 ]",
  "cardAtk": "공격력 0",
  "cardDef": "수비력 1800",
  "cardText": "이 카드명의 효과는 1턴에 1번밖에 사용할 수 없다. ..(중략)"
}
```
