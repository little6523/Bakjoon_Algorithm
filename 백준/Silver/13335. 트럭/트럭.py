n, w, L = map(int, input().split())
a = list(map(int, input().split()))

bridge = [0] * w
time = 0

while bridge:
    bridge.pop(0)
    if a:
        if sum(bridge) + a[0] <= L:
            bridge.append(a.pop(0))
        else:
            bridge.append(0)
            
    time += 1
    
print(time)