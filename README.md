### gitignore 적용되지 않는 경우

```bash
git rm -r --cached .
git add .
git commit -m "fixed untracked files"
```

### 알고리즘 노트
- c++ 자료형 범위
    - int: 2^32, 대략 -21억 ~ +21억
    - long long: 2^63

- 시간 복잡도 계산
    - 1초에 약 1억 번으로 판단
    - ex. n = 5000: O(n^2), n = 200,000: O(nlogn)
---
### [c++ 코드 참고](https://github.com/ndb796/python-for-coding-test/blob/master/README.md)

### 키 세팅
- `Ctrl + K + F`: 선택한 부분 자동 정렬
- `Alt + Shift + A`: 블록 주석
- `Ctrl + Alt + C`: 빌드
- `Ctrl + Alt + R`: 실행

### 코드 스니펫 변경
- File - Preferences - Configure User Snippets - cpp.json 파일 편집

### 키 바인딩 변경
- [Keyboard Shortcuts](https://pybasall.tistory.com/353)

### 참고
- [vscode에서 c++ 코딩 환경 구축](https://velog.io/@youhyeoneee/%ED%99%98%EA%B2%BD-%EC%84%A4%EC%A0%95-VS-Code-%EC%97%90%EC%84%9C-CC-%EC%BD%94%EB%94%A9-%ED%99%98%EA%B2%BD-%EA%B5%AC%EC%B6%95%ED%95%98%EA%B8%B0-Windows)
- 한글 깨짐 해결: 인코딩 방식 `UTF-8` -> `EUC-KR` 로 변경
- ![화면 캡처 2024-07-23 170255](https://github.com/user-attachments/assets/4cc1ef6c-77af-4aba-8a1c-1fa8a0db155f)    
