## Notes

#### 주의할 점

- 입력코드 직접 작성 시 ( java.io 사용할 경우) 메인 함수에서 `throws Exception` 필수
- 메서드 사용 시 공통변수 및 메서드에 `static` 필수

### Types

#### Array

- 1차원 배열 요소 모두 출력: `System.out.println(**Arrays.toString(array)**);`

### Algorithm

#### DFS

- 재귀로 구현: `dfs(x)`
    - `visited[x] = 1` → x의 인접 원소 `ai` 돌며 1) 해당 간선 존재 2) `visited[ai]=0` 이면 `dfs(ai)`