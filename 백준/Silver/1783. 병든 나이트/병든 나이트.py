# n: 세로, m: 가로
n, m = map(int, input().split())

# n == 1일 때 이동 x
if n == 1:
    print(1)

# n == 2일 때, 방문횟수 최대 4 (이동횟수 최대 3)
elif n == 2:
    print(min(4, (m+1)//2))

# n > 2가 되어도 m < 7인 경우는 방문횟수 최대 4 (이동횟수 최대 3)
elif m < 7:
    print(min(4, m))
    
# n > 2, m => 7 이라면 처음에만 4방법 사용 후, 1번과 4번방법만 사용하여 이동
else:
    print(5 + m - 7)