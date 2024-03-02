n = int(input())
word = [input() for _ in range(n)]

answer = 0

for s in word:
    checker = []
    temp = 1
    checker.append(s[0])
    if len(s) <= 2:
        answer += 1
    else:
        for i in range(len(s)-1):
            if s[i] != s[i+1] and s[i+1] in checker:
                temp = 0
                break
            if s[i] != s[i+1] and s[i+1] not in checker:
                checker.append(s[i+1])

        if temp == 1:
            answer += 1
            
print(answer)