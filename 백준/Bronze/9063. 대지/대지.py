import sys
input = sys.stdin.readline

n = int(input())
point = [list(map(int, input().split())) for _ in range(n)]

min_x, min_y = 10000, 10000
max_x, max_y = -10000, -10000
for p in point:
    if p[0] < min_x:
        min_x = p[0]
    if p[0] > max_x:
        max_x = p[0]
        
    if p[1] < min_y:
        min_y = p[1]
    if p[1] > max_y:
        max_y = p[1]
        
print((max_x-min_x) * (max_y-min_y))