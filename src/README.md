### **`STEP 05`**

- [x] 시나리오 선정 및 프로젝트 Milestone 제출
- [x] 시나리오 요구사항 별 분석 자료 제출
- [x] 자료들을 리드미에 작성 후 PR 링크 제출

* 선택한 시나리오 : 콘서트 예약 


* 시나리오 선정 이유 : 실제로 많은 트래픽이 한번에 몰리는 사이트를 처리해 볼 수 있는 경험은 많이 없을 것 같아서 선택했고 또한 실무에서 레디스를 쓰고있지만 단순히 구동하는 것 외에 따로 써보지 못하여서 레디스에 대한 이해도를 높이고자 선택하였다.

>프로젝트 마일스톤

* 시나리오 분석

>시퀀스 다이어그램(예약)

>플로우 차트(전체 프로세스)
> 
> 
> ### **`STEP 06`**

- [x] ERD 설계 자료 제출
- [ ] API 명세 및 Mock API 작성
- [x] 자료들을 리드미에 작성 후 PR링크 제출 ( 채택할 기본 패키지 구조, 기술 스택 등 )

>ERD 설계 자료

>기본 패키지 구조

```
├─api
│  ├─booking
│  │  ├─controller
│  │  ├─dto
│  │  └─usecase
│  ├─concert
│  │  ├─controller
│  │  ├─dto
│  │  └─usecase
│  ├─concertSchedule
│  │  ├─controller
│  │  ├─dto
│  │  └─usecase
│  ├─money
│  │  ├─controller
│  │  ├─dto
│  │  └─usecase
│  ├─payment
│  │  ├─controller
│  │  ├─dto
│  │  └─usecase
│  ├─seat
│  │  ├─controller
│  │  ├─dto
│  │  └─usecase
│  ├─token
│  │  ├─controller
│  │  ├─dto
│  │  └─usecase
│  └─user
│      ├─controller
│      ├─dto
│      └─usecase
├─config
└─domain
    ├─booking
    │  ├─models
    │  ├─repositories
    │  └─services
    ├─concert
    │  ├─models
    │  ├─repositories
    │  └─services
    ├─concertSchedule
    │  ├─models
    │  ├─repositories
    │  └─services
    ├─money
    │  ├─models
    │  ├─repositories
    │  └─services
    ├─payment
    │  ├─models
    │  ├─repositories
    │  └─services
    ├─seat
    │  ├─models
    │  ├─repositories
    │  └─services
    ├─token
    │  ├─models
    │  ├─repositories
    │  └─services
    └─user
        ├─models
        ├─repositories
        └─services
```

>기술 스택