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
