n, b = map(str, input().split())
b = int(b)

answer = 0
cur_b = 1
for i in range(len(n)-1, -1, -1):
    if 65 <= ord(n[i]) <= 90:
        answer += cur_b * (ord(n[i]) - 55)
    else:
        answer += cur_b * int(n[i])
    cur_b *= b
        
print(answer)