T = int(input())
parenthesis = [list(map(str, input())) for _ in range(T)]
answer = ['YES' for _ in range(T)]

for i in range(T):
    stack = []
    for ch in parenthesis[i]:
        if ch == ')' and len(stack) == 0:
            answer[i] = 'NO'
            break
        elif ch == ')' and len(stack) > 0:
            stack.pop()
        
        if ch == '(':
            stack.append(ch)
    
    if len(stack) > 0:
        answer[i] = 'NO'
        
for ans in answer:
    print(ans)