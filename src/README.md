### **`STEP 06`**

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