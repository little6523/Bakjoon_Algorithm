import sys
input = sys.stdin.readline

s = input().rstrip()
check = [0] * 26

for i in range(len(s)):
    asc = ord(s[i])
    if ord('A') <= asc <= ord('Z'):
        check[asc-65] += 1
    else:
        check[asc-97] += 1

c_max = max(check)
answer = chr(check.index(c_max) + 65)
cnt = 0
for i in range(26):
    if check[i] == c_max:
        cnt += 1
    
    if cnt == 2:
        answer = '?'
        break
    
print(answer)