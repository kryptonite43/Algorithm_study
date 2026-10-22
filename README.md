## Notes

### 주의할 점

- 입력코드 직접 작성 시 (`java.io` 사용할 경우) 메인 함수에서 `throws Exception` 필수
- 메서드 사용 시 공통변수 및 메서드에 `static` 필수

---

### Types

#### Array

- 1차원 배열 요소 모두 출력: `System.out.println(**Arrays.toString(array)**);`

#### Char

- `String`→`Char`: `str.charAt(0);`
- `String`→`Char[]`: `str.toCharArray();`
---

### Algorithm

#### DFS

- 재귀로 구현: `dfs(x)`
    - `visited[x] = 1` → x의 인접 원소 `ai` 돌며 1) 해당 간선 존재 2) `visited[ai]=0` 이면 `dfs(ai)`
- `m<n^2` or `n>2000`이면 인접 리스트 쓰는 걸로 생각하기

---

### Tips

- ***좌표에서*** dx, dy 배열 사용 시 입력 char로 방향 들어올 때 인덱스 설정
    
    ```java
    int[] dx = {1, 0, -1, 0}; // E N W S
    int[] dy = {0, 1, 0, -1};
    char dir = 'N';
    int ind = "ENWS".indexOf(dir);
    ```
    
    - ***행렬에서*** dx dy 사용
        
        ```java
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        ```