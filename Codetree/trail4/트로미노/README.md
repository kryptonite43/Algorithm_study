# [[챌린지]트로미노](https://www.codetree.ai/trails/complete/curated-cards/challenge-tromino)

| 항목 | 내용 |
|---|---|
| 분류 | Trail |
| 커리큘럼 | [Trail 4 / Simulation / 격자 안에서 완전탐색](https://www.codetree.ai/trail-info/intermediate-low/) |
| 난이도 | 보통 |
| 경험치 | 90 XP |

---

n*m 격자 내부에 3칸짜리 다음 둘 중 하나를 올린다 - 회전, 뒤집기 가능
1. ㄴ 블럭
2. ㅡ 블럭

 n*m 격자 최대 : 40000개
 arr[i][j] 값 최대 = 1000, 3칸 다 더해도 최대 3000이므로 자료형은 int

 1. ㄴ 블럭의 경우 시작이 (i,j) 일 때 를 사용함. 
 범위는 그대로 n*m 가져가고 아래 좌표가 실제로 범위 벗어날 때 해당 건을 무효화
 1) 0: (i,j) (i+1,j) (i+1,j+1)
 2) 90: (i,j) (i,j+1) (i+1,j)
 3) 180: (i,j) (i,j+1), (i+1,j+1)
 4) 270: (i,j+1) (i+1,j+1) (i+1,j)

 2. ㅡ 블럭 시작 (i,j)
 1) (i,j) (i,j+1) (i,j+2)
 2) (i,j) (i+1,j) (i+2,j)

 시간복잡도 안에 가능
