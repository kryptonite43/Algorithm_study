# [[챌린지]마을 구분하기](https://www.codetree.ai/trails/complete/curated-cards/challenge-seperate-village)

| 항목 | 내용 |
|---|---|
| 분류 | Trail |
| 커리큘럼 | [Trail 4 / DFS / DFS](https://www.codetree.ai/trail-info/intermediate-low/) |
| 난이도 | 보통 |
| 경험치 | 70 XP |

---

- 사람 1 벽 0. 벽으로 둘러싸인 사람이 한 마을임
- 총 마을 개수 (사람묶음 개수), 각 마을의 사람수 배열(오름차순 출력)
- 격자수 최소 25, 최대 625
- dfs를 돌건데, 
    - 일단 사람이 있는 맨 처음 위치를 기준으로 dfs를 돌음.
    - dfs 내에서 인접 사람 있을 때마다 사람수 카운트 올리고 마지막에 이걸 리턴, 리스트 저장
    - dfs를 반복하는 이중 for문 안에서 dfs 한번 끝나면 마을 카운트 올림

- 엣지 케이스
    - 모두 벽인 경우
    - 모두 사람인 경우
    - 벽이 있는데 사람이 다 이어진 경우
