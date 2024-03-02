import sys

def lets_dice(Direction):
    global D_MAP, x, y

    dice_state(Direction)

    if D_MAP[x][y] == 0:
        D_MAP[x][y] = dice[0][3]

    else:
        dice[0][3] = dice[1][3] = D_MAP[x][y]
        D_MAP[x][y] = 0

def dice_state(Direction):
    if Direction == 1:
        tmp = dice[0][3]
        for i in range(2, -1, -1) :
            dice[0][i+1] = dice[0][i]

        dice[0][0] = tmp
        dice[1][1] = dice[0][1]
        dice[1][3] = dice[0][3]

    elif Direction == 2:
        tmp = dice[0][0]
        for i in range(3) :
            dice[0][i] = dice[0][i+1]

        dice[0][3] = tmp
        dice[1][1] = dice[0][1]
        dice[1][3] = dice[0][3]

    elif Direction == 3:
        tmp = dice[1][0]
        for i in range(3) :
            dice[1][i] = dice[1][i+1]

        dice[1][3] = tmp
        dice[0][1] = dice[1][1]
        dice[0][3] = dice[1][3]

    elif Direction == 4:
        tmp = dice[1][3]
        for i in range(2, -1, -1) :
            dice[1][i+1] = dice[1][i]

        dice[1][0] = tmp
        dice[0][1] = dice[1][1]
        dice[0][3] = dice[1][3]

def move(Direction):
    global x, y

    if Direction == 1: # 동
        y += 1
        if(check_out() == 0):
            lets_dice(Direction)
            print(dice[0][1])
    
    elif Direction == 2: # 서
        y -= 1
        if(check_out() == 0):
            lets_dice(Direction)
            print(dice[0][1])

    elif Direction == 3: # 북
        x -= 1
        if(check_out() == 0):
            lets_dice(Direction)
            print(dice[0][1])

    elif Direction == 4: # 남
        x += 1
        if(check_out() == 0):
            lets_dice(Direction)
            print(dice[0][1])

def check_out():
    global x, y

    if x < 0:
        x += 1
        return 1
    
    elif x > N-1:
        x -= 1
        return 1
    
    elif y < 0:
        y += 1
        return 1
    
    elif y > M-1:
        y -= 1
        return 1

    return 0

dice = [[0, 0, 0, 0],
        [0, 0, 0, 0]]

# dice[0] : 가로, dice[1] : 세로

global x, y

N, M, x, y, K = map(int, input().split())

D_MAP = [[0]*M for _ in range(N)]

for i in range(N) :
    D_MAP[i] = list(map(int, input().split()))

Command = input().split()
for i in range(len(Command)):
    Command[i] = int(Command[i])

for i in range(K) :
    move(Command[i])