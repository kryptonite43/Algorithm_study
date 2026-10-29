# [[개념]최소 경로로 탈출하기](https://www.codetree.ai/trails/complete/curated-cards/intro-escape-with-min-distance)

| 항목 | 내용 |
|---|---|
| 분류 | Trail |
| 커리큘럼 | [Trail 4 / BFS / 가중치가 동일한 그래프에서의 BFS](https://www.codetree.ai/trail-info/intermediate-low/) |
| 난이도 | 쉬움 |
| 경험치 | 40 XP |

-----
-----
---


- n*m 영역 상하좌우 이동, 뱀 있으면 이동불가
- 우측하단까지 최단거리를 구해라 -> BFS 문제
- 뱀없으면 1 뱀있으면 0
- n, m 둘다 2이상 100이하 -> 최대 board 10000임.
- bfs 시간복잡도:
- 도달못하면 -1 출력

케이스
- 시작, 끝 빼고 다 뱀인 경우
- 도달 못하는 경우
- 최단경로 여러개일때
- 뱀 하나도 없는경우

++

큐에 넣자마자 방문처리해야하는데, 큐에서 꺼낼때 방문처리해서 시간초과로 오답