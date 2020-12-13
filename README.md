# hello-codesquad
codesquad 테스트 문제 제출용
## 1단계 단어 밀어내기 구현
* 입력 : 단어하나 정수(-100 <= N <100), l(L) 또는 r(R)
* 출력 : 주어진 숫자만큼 주어진 방향대로 밀어낸 단어 

1) BufferedReader 로 입력받아 공백을 기준으로 나눠 배열에 담고, 단어, 옮길 횟수, 방향을 초기화합니다.
2) R일경우 1 L일경우 -1로 구분하며, 옮길횟수가 음수일경우 방향을 바꾸고 횟수는 절댓값으로 지정합니다.
3) r/l 경우에 따라 substring 하여 답안을 구성합니다. r: 문자열 인덱스기준 (length-cnt ~ length) + (0 ~ length-cnt) 
                                            / l: 문자열 인덱스기준 (cnt ~ length) + (0 ~ cnt)  
이때, cnt는 문자열의 길이와의 모드연산을 구하여 잘라낼 기준점을 찾습니다. ex) 문자열 길이 5일때, cnt=1은 cnt=6 과 동일 (1%5 == 6%5)

## 2단계 평면 큐브 구현
* 입력 : U(')/R(')/L(')/B(')/Q
* 출력 : 시작 초기 상태 출력 , 프롬프트 , 여러문자 입력시 순서대로 매 과정 출력

1) while 문으로 Q 입력 받기 전 까지 반복
2) 3*3 2차원 배열 큐브값 초기화
3) 명령 char 배열로 받아 for문 돌리면서 다음값이 ' 인 경우 이어 붙여서  push 함수 호출
4) push함수에 들어온 명령어 U,B,R,L 포함 여부에따라 1차 분류/ 명령어에 ' 포함 여부에 따라 이동 방향 결정 
5) 변경될 라인에 해당하는 열/행 읽어 String 으로 저장후 step-1 적용 단어 밀어내기 수행 
6) 2차 배열 업데이트 및 2차원 배열 출력함수 호출 
