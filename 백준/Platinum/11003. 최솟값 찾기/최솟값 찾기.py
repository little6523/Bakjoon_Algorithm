from collections import deque

n, l = map(int, input().split())
a = list(map(int, input().split()))

q = deque() # q = (a[0],0) (a[1],1) 

for i in range(len(a)):
    while q and q[-1][0] > a[i]:
        q.pop()
    
    # l만큼의 크기를 가진 deque이 이동할 때, (i - l + 1)보다 작은 인덱스는 자동적으로 제거되야함
    # ex) l이 5인 경우, 인덱스(i)는 0부터 시작하므로 i - l + 1 => (0 - 5 + 1) ~ (len(a)-1 -5 + 1)의 범위내에서 순차적으로 증가할 때마다
    # 덱의 맨 앞의 요소의 인덱스를 비교하여 삭제됬어야할 인덱스에 해당하면 popleft() 수행
    while q and q[0][1] < i - l + 1:
        q.popleft()
        
    q.append((a[i], i))
    print(q[0][0], end=' ')