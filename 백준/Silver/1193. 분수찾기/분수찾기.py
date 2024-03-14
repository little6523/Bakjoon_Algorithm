n = int(input())

x = 1; y = 1
s = 1; i = 1

while s < n:
    s = i * (1 + i) // 2   # 등차수열 합 공식: n(a + l) / 2
    i += 1
    
    if s >= n:
        i -= 1
        s = (i-1) * (1 + i-1) // 2
        break
    
if i % 2 == 0:
    y = i
    for i in range(1, n-s):
        x += 1; y -= 1
    
else:
    x = i
    for i in range(1, n-s):
        x -= 1; y += 1
        
print('%d/%d' %(x, y))