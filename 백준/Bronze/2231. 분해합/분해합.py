n = input()

original = int(n) - len(n) * 9
if original < 0:
    if int(n) < 10:
        original = 1
    else:
        original = int(n) - (len(n) - 1) * 9
        
n = int(n)
flag = 0
while original < int(n):
    splited = list(map(int, str(original)))
    
    if original + sum(splited) == n:
        flag = 1
        break
    else: original += 1

if flag == 1: print(original)
else: print(0)