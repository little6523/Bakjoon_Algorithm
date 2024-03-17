a, b, v = map(int, input().split())

# 하루에 올라갈 수 있는 높이 => a-b
day = (v-a) // (a-b)

if (v-a) % (a-b) > 0:
    day += 2
else:
    day += 1
    
print(day)