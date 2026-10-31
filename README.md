## Notes
#### 주의할 점

- 입력코드 직접 작성 시 (`java.io` 사용할 경우) 메인 함수에서 `throws Exception` 필수
- 메서드 사용 시 공통변수 및 메서드에 `static` 필수

### Types

#### Array

- 1차원 배열 요소 모두 출력: `System.out.println(***Arrays.toString(array)***);`
- 2차원 배열 값 초기화
    
    ```java
    int[][] board = new int[n][m];
    for (int i=0; i<n; i++) {
    	Arrays.fill(board[i], 0);
    }
    ```
    

#### Char

- `String`→`Char`: `str.charAt(0);`
- `String`→`Char[]`: `str.toCharArray();`

#### Queue

- 우선순위 큐 `PriorityQueue`: 특정 순서에 따라 정렬해 저장, 시간복잡도 O(nlogn)
    
    ```java
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(1); // 원소 추가
    pq.peek(); // 맨위 확인만
    pq.poll(); // 맨위 제거
    ```
    

### Algorithm

#### DFS

- 정답이 특정 깊이에 있을 때
- 재귀로 구현: `dfs(x)`
    - `visited[x] = 1` → x의 인접 원소 `ai` 돌며 1) 해당 간선 존재 2) `visited[ai]=0` 이면 `dfs(ai)`
- n:정점 m: 간선 수 일때, `m<n^2` or `n>2000`이면 인접 리스트 쓰는 걸로 생각하기

#### BFS

### Tips

- int 범위 -2^31~2^31-1
- ***좌표에서*** dx, dy 배열 사용 시 입력 char로 방향 들어올 때 인덱스 설정
    
    ```bash
    int[] dx = {1, 0, -1, 0}; // E N W S
    int[] dy = {0, 1, 0, -1};
    char dir = 'N';
    int ind = "ENWS".indexOf(dir);
    ```
    
    - ***행렬에서*** dx dy 사용
        
        ```bash
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        ```