n, m = map(int, input().split())
h = list(map(int, input().split()))

left, right = 0, 1_000_000_000
mid = 0
answer = 0
# 가져갈 수 있는 나무의 길이 => sum(h[i] - mid)
while left <= right:
    h_sum = 0
    mid = (left + right) // 2 # mid: 나무를 벨 높이
    for i in range(len(h)):
        take_tree = h[i] - mid
        
        if take_tree <= 0: continue
        h_sum += take_tree
    
    if h_sum >= m:
        left = mid + 1
        if answer < mid:
            answer = mid
        
    elif h_sum < m:
        right = mid - 1
        
print(answer)