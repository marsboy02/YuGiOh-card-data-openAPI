# YuGiOh-card-data-api

유희왕 카드 게임에 대한 정보를 제공하는 API입니다.

HTTP GET 요청을 통해 [유희왕 데이터베이스](https://www.db.yugioh-card.com/yugiohdb/?request_locale=ko)
에서 다양한 유희왕 정보를 JSON으로 응답받아 사용할 수 있습니다.
모든 정보는 한국어로 제공됩니다.

- **SWAGGER UI** : (api.yugiohcard.kr/docs)[https://api.yugiohcard.kr/docs]

## Environment

```bash
$ git clone https://github.com/marsboy02/yugioh-card-data-api
```

```bash
$ cd yugioh-card-data-api
```

```bash
$ ./gradlew build testClasses -x test
```

```bash
$ java -jar build/libs/*.jar
```

## API docs

### 카드 조회

`https://api.yugiohcard.kr/card/{카드명}`

한글로 검색한 유희왕 카드의 정보를 반환합니다.

**응답 예시**

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

### 리미트 레귤레이션 정보 확인

`https://api.yugiohcard.kr/regulation/{타입명}`

유희왕 OCG 제한 카드 리스트를 반환합니다. 타입이 없는 경우 모든 리스트를 반환합니다.

|        타입명         | 설명                                |
| :-------------------: | ----------------------------------- |
|       forbidden       | 금지 카드 리스트를 반환합니다.      |
|        limited        | 제한 카드 리스트를 반환합니다.      |
|     semi_limited      | 준제한 카드 리스트를 반환합니다.    |
|        update         | 제한 규정이 바뀐 카드를 반환합니다. |
| release_of_restricted | 제한 규정이 바뀐 카드를 반환합니다. |

**응답 예시**

```JSON
[
  "BF－농그림자의 고우후우",
  "EM 멍키보드",
  "Em 히구루미",
  "M.X－세이버 인보커",
  "No.16 쇼크 마스터",
  "No.95 갤럭시아이즈 다크매터 드래곤",
  "SNo.0 호프 제알",
  "The tyrant NEPTUNE",
  "교체 깨구리"
]
```

## License

- [MIT License](https://opensource.org/license/mit/)
