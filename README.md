### **`STEP 05`**

- [x] 시나리오 선정 및 프로젝트 Milestone 제출
- [x] 시나리오 요구사항 별 분석 자료 제출
- [x] 자료들을 리드미에 작성 후 PR 링크 제출

*  #### 선택한 시나리오 : 콘서트 예약 

* 시나리오 선정 이유 : 실제로 많은 트래픽이 한번에 몰리는 사이트를 처리해 볼 수 있는 경험은 많이 없을 것 같아서 선택했고 또한 실무에서 레디스를 쓰고있지만 단순히 구동하는 것 외에 따로 써보지 못하여서 레디스에 대한 이해도를 높이고자 선택하였다.

>프로젝트 마일스톤

[피드백 받고 마일스톤 수정: 2024-10-14]

- 기능 개발과 테스트를 함께 진행
- 추후 고도화에 대해서도 구체적으로 변경할 예

[![](https://mermaid.ink/img/pako:eNqFlF9v0lAUwL_KzX0usy2lXftmQvSJJ580vDS0Y0SghJXESZZM7JbJWBZj0boULIY5SXioji17GF-Ie-538BbG1uLE-9Se8zv_7z1NXLAME2u4qFdtO19F7Nglu2yip-h5JELZkl6s65WFytBt85lVr-g2eslOKpdLZbML1Y5ZsEtWFVHXIQMfgh5t3yBwhrNLZwFEB4590vLIjzF4Q6YMIOgiTeRFKSXwKT7DIdF4gMnFEfRuoT2khwzufwTnVwxWOCTE4GTY970kvJmEK1bhNdJrJTS7GlPPiYFqEoTAh2v_QS_wD_plwdB1aGtID07gtxc5hEG49EvCUwRTl3zy7_KPFRew4ibweTJXxl2QSwfR0wk5cf-qQxBX0vOOoDtFs3CftM8RaQVw4T9B8L0DTi9RH7r3ICV7DH0XugME1yMIHGY6COlZ5x-mq-M5_gk-S_WgE40o6vq8xJiBHGWLVrsZA5QYcN_Ox_uVEMc6wgamrEkqFmxOrgSb3YRR52ahT0L_v8FEJRmMHl7R7ijWgUfJ-1iXATl16FeXnN8uTCeIdPbhbES-fUDMnPQ96k4RuwPsgSRuCnFdFiGyg9aYGdCuB1_Ga6yXmQgpPs2mlrgzi9oYRDsjehiQi3draMzhisnee8lgO6IZyfPY3jYrZh5r7NMwt_RG2c7jfHWPoXrDtl7sVgtYs-sNk8N1q1HcxtqWXt5hf41atD7u9skSqenVV5YV_8VaE7_BGrsdG5sSL6bTorzJy5KYSXN4F2sCk2ckQVYVlc-ooqhk9jj8du5C2BBUmc8IYlpVZSUtySKHTaNkW_XcYsnNd93eH-gJ-TI?type=png)](https://mermaid.live/edit#pako:eNqFlF9v0lAUwL_KzX0usy2lXftmQvSJJ580vDS0Y0SghJXESZZM7JbJWBZj0boULIY5SXioji17GF-Ie-538BbG1uLE-9Se8zv_7z1NXLAME2u4qFdtO19F7Nglu2yip-h5JELZkl6s65WFytBt85lVr-g2eslOKpdLZbML1Y5ZsEtWFVHXIQMfgh5t3yBwhrNLZwFEB4590vLIjzF4Q6YMIOgiTeRFKSXwKT7DIdF4gMnFEfRuoT2khwzufwTnVwxWOCTE4GTY970kvJmEK1bhNdJrJTS7GlPPiYFqEoTAh2v_QS_wD_plwdB1aGtID07gtxc5hEG49EvCUwRTl3zy7_KPFRew4ibweTJXxl2QSwfR0wk5cf-qQxBX0vOOoDtFs3CftM8RaQVw4T9B8L0DTi9RH7r3ICV7DH0XugME1yMIHGY6COlZ5x-mq-M5_gk-S_WgE40o6vq8xJiBHGWLVrsZA5QYcN_Ox_uVEMc6wgamrEkqFmxOrgSb3YRR52ahT0L_v8FEJRmMHl7R7ijWgUfJ-1iXATl16FeXnN8uTCeIdPbhbES-fUDMnPQ96k4RuwPsgSRuCnFdFiGyg9aYGdCuB1_Ga6yXmQgpPs2mlrgzi9oYRDsjehiQi3draMzhisnee8lgO6IZyfPY3jYrZh5r7NMwt_RG2c7jfHWPoXrDtl7sVgtYs-sNk8N1q1HcxtqWXt5hf41atD7u9skSqenVV5YV_8VaE7_BGrsdG5sSL6bTorzJy5KYSXN4F2sCk2ckQVYVlc-ooqhk9jj8du5C2BBUmc8IYlpVZSUtySKHTaNkW_XcYsnNd93eH-gJ-TI)


* 시나리오 분석

>시퀀스 다이어그램(예약)

[피드백 받고 마일스톤 수정: 2024-10-14]

- concertSchedule이 없는 경우 concertSchedule -> concert -> user로 반환

![콘서트 예약 시스템-2024-10-14-054413](https://github.com/user-attachments/assets/b4c4316e-edd0-49e3-a92f-0b8bbd9f5e99)


>플로우 차트(전체 프로세스)

![콘서트 예약 시스템 - 플로우 차트](https://github.com/user-attachments/assets/1cd4c9cf-9f80-427b-b1ad-5df8806c2c4b)


### **`STEP 06`**

- [x] ERD 설계 자료 제출
- [ ] API 명세 및 Mock API 작성
- [x] 자료들을 리드미에 작성 후 PR링크 제출 ( 채택할 기본 패키지 구조, 기술 스택 등 )

>ERD 설계 자료

[피드백 이후 ERD 수정 : 2024-10-14]

![erd수정 10월 14일](https://github.com/user-attachments/assets/dddf1f18-1993-4394-ab88-28a682945ae0)


```
테이블 설명 : 

TB_TOKEN : 토큰 발급 후 토큰 정보를 저장한다.

TB_USER : 유저 정보를 저장한다.

TB_MONEY : 유저가 충전한 금액 정보를 저장한다.

TB_PAYMENT : 결제를 하기 위해 필요한 정보를 저장한다.

TB_CONCERT : 콘서트 정보를 저장한다.

TB_CONCERT _SCHEDULE : 콘서트 스케줄에 관련한 정보를 저장한다.

TB_SEAT : 콘서트 스케줄에 따른 좌석 정보를 저장한다.

TB_BOOKING : 예약이 완료 되면 완료 정보를 저장한다.

TB_BOOKING_HISTORY : 예약 관련 이력을 저장한다.
```


>기본 패키지 구조

```
└─com
    └─hhplus
        └─hhplus3week
            ├─app
            │  ├─api
            │  │  ├─booking
            │  │  │  ├─controller
            │  │  │  └─dto
            │  │  ├─concert
            │  │  │  ├─controller
            │  │  │  └─dto
            │  │  ├─concertSchedule
            │  │  │  ├─controller
            │  │  │  └─dto
            │  │  ├─money
            │  │  │  ├─controller
            │  │  │  └─dto
            │  │  ├─payment
            │  │  │  ├─controller
            │  │  │  └─dto
            │  │  ├─seat
            │  │  │  ├─controller
            │  │  │  └─dto
            │  │  ├─token
            │  │  │  ├─controller
            │  │  │  └─dto
            │  │  └─user
            │  │      ├─controller
            │  │      └─dto
            │  └─domain
            │      ├─booking
            │      │  ├─models
            │      │  ├─repositories
            │      │  └─services
            │      ├─concert
            │      │  ├─models
            │      │  ├─repositories
            │      │  └─services
            │      ├─concertSchedule
            │      │  ├─models
            │      │  ├─repositories
            │      │  └─services
            │      ├─money
            │      │  ├─models
            │      │  ├─repositories
            │      │  └─services
            │      ├─payment
            │      │  ├─models
            │      │  ├─repositories
            │      │  └─services
            │      ├─seat
            │      │  ├─models
            │      │  ├─repositories
            │      │  └─services
            │      ├─token
            │      │  ├─models
            │      │  ├─repositories
            │      │  └─services
            │      └─user
            │          ├─models
            │          ├─repositories
            │          └─services
            └─config
```

패키지 구조를 구성한 이유 :

- 명확한 책임 분리: 각 기능(booking, concert, user 등)은 자신만의 패키지를 가지며, 이 패키지들은 controller, dto, usecase와 같은 계층별로 구분되어 있습니다. 이 구조는 각 계층의 책임을 명확하게 구분하여 코드의 복잡성을 줄입니다. 예를 들어, controller는 HTTP 요청을 처리하고, usecase는 비즈니스 로직을 수행하며, dto는 데이터를 전달하는 역할을 하므로, 이들을 별도로 관리하는 것이 쉽습니다.

- 확장성: 새로운 기능을 추가할 때, 기존 패키지 구조에 맞게 새로운 패키지(예: ticket 기능)를 추가하는 방식으로 확장할 수 있습니다. 이로 인해 코드베이스가 커지더라도 일관된 구조를 유지할 수 있어, 확장성 면에서 유리합니다.

- 재사용성: domain 패키지에는 비즈니스 로직(services), 데이터 모델(models), 저장소(repositories)가 정의되어 있어, 여러 곳에서 재사용할 수 있습니다. 이로 인해 중복된 코드 작성이 줄어들고, 특정 비즈니스 로직을 여러 컨트롤러에서 사용할 수 있게 됩니다.

- 유지보수 용이성: 기능별, 계층별로 코드가 구분되어 있어, 유지보수가 쉽습니다. 특정 기능에 문제가 발생했을 때 해당 기능의 패키지로 빠르게 접근할 수 있고, 계층 구조 덕분에 문제의 위치를 더 쉽게 파악할 수 있습니다.

- 테스트 용이성: 각 계층이 독립적으로 존재하기 때문에, 단위 테스트 및 통합 테스트를 작성하기 용이합니다. 예를 들어, usecase 계층의 비즈니스 로직을 별도로 테스트하거나, repositories에 대한 데이터 접근 테스트를 수행할 수 있습니다.

- 의존성 관리: 계층 간 의존성이 명확하게 구분되어 있어, 의존성 주입(Dependency Injection)과 같은 디자인 패턴을 적용하기 수월합니다. 이를 통해 코드의 결합도를 낮추고, 모듈화된 구조를 더욱 강화할 수 있습니다.

[피드백 이후 패키지 구조 수정 : 2024-10-14]

- 수정 사항 : usecase 비즈니스 로직을 처리하고, service도 비즈니스 로직을 수행하여 중복 계층이라 삭제. app/config로 가장 최상위 패키지 구분.
- 미 반영 사항 : 도메인 별로 분리 할 필요성이 있는지 고민. BookingDTO 네이밍 고민중..

>기술 스택

* Spring Boot Framework
* Database: MariaDB
* Redis
* Kafka