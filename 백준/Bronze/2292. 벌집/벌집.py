n = int(input())

# 1 = 1
# 2 = 2~7
# 3 = 8~19
# 4 = 20~37
# 5 = 38~61
end = 1
turn = 1
while True:
    if end >= n:
        print(turn)
        break
    end += turn * 6
    turn += 1