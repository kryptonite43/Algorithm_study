# [[개념]1차원 젠가](https://www.codetree.ai/trails/complete/curated-cards/intro-jenga-1d)

| 항목 | 내용 |
|---|---|
| 분류 | Trail |
| 커리큘럼 | [Trail 4 / Simulation / 격자 안에서 터지고 떨어지는 경우](https://www.codetree.ai/trail-info/intermediate-low/) |
| 난이도 | 쉬움 |
| 경험치 | 40 XP |


---

- s~e의 블록을 제거: 실제로 index는 s-1 부터 e-1 까지
- 제거하는 블록 개수: e-s+1 이므로 전체 블록 개수는 n-(e-s+1)이 됨
- 엣지케이스
    - n이 2이고 s,e가 두번 다 1범위
