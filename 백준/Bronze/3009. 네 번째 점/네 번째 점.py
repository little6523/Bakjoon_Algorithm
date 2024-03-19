point = [list(map(int, input().split())) for _ in range(3)]
answer = []

x = []
y = []
for p in point:
    if p[0] not in x:
        x.append(p[0])
    else:
        x.remove(p[0])
        
    if p[1] not in y:
        y.append(p[1])
    else:
        y.remove(p[1])
    
print(x[0], y[0])