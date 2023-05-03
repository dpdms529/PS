# 구간 합
- [p003 구간 합 구하기 4](https://www.acmicpc.net/problem/11659)
- [p004 구간 합 구하기 5](https://www.acmicpc.net/problem/11660)
- [p005 나머지 합](https://www.acmicpc.net/problem/10986)

## 합 배열 S
``` java
// A[0]부터 A[i]까지의 합 
S[i] = A[0] + A[1] + ... + A[i-1] + A[i];

// A[0][0]부터 A[i][j]까지의 합
S[i][j] = A[0][0] + A[0][1] + ... + A[i][j-1] + A[i][j];
```

## 합 배열 S를 만드는 공식
```java
//1차원
S[i] = S[i-1] + A[i];

//2차원
S[y][x] = S[y][x-1] + s[y-1][x] - S[y-1][x-1] + A[y][x];
```

## 구간 합을 구하는 공식
```java
// i에서 j까지 구간 합
S[j] - S[i-1];

// (x1,y1)에서 (x2,y2)까지 구간 합
S[y2][x2] - s[y2][x1-1] - S[y1-1][x2] + S[y1-1][x1-1];
```