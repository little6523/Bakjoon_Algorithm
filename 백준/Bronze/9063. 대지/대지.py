n = int(input())
point = [list(map(int, input().split())) for _ in range(n)]

max_x = max(point, key = lambda x:x[0])
min_x = min(point, key = lambda x:x[0])
max_y = max(point, key = lambda y:y[1])
min_y = min(point, key = lambda y:y[1])
print((max_x[0] - min_x[0]) * (max_y[1] - min_y[1]))