n = int(input())

original = 1
flag = 0
while original < n:
    splited = list(map(int, str(original)))
    
    if original + sum(splited) == n:
        flag = 1
        break
    else: original += 1

if flag == 1: print(original)
else: print(0)