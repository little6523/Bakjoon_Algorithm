data = [list(map(str, input())) for _ in range(5)]

longest = len(data[0])
for i in range(1, 5):
    if longest < len(data[i]):
        longest = len(data[i])
        
for i in range(5):
    if len(data[i]) < longest:
        while len(data[i]) < longest:
            data[i].append(-1)
            
for i in range(longest):
    for j in range(5):
        if data[j][i] == -1:
            continue
        print(data[j][i], end='')