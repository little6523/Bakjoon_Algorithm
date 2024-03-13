class stack:
    def __init__(self):
        self.my_stack = []
        
    def push(self, x):
        self.my_stack.append(x)
        
    def pop(self):
        if len(self.my_stack) == 0: print(-1)
        else: print(self.my_stack.pop())
        
    def size(self):
        print(len(self.my_stack))
        
    def empty(self):
        if self.my_stack: print(0)
        else: print(1)
        
    def top(self):
        if len(self.my_stack) == 0: print(-1)
        else: print(self.my_stack[-1])
        
    def command(self, comm):
        if len(comm) == 2: x = comm[1]
        com = comm[0]
        
        if com == 'push':
            self.push(int(x))
        elif com == 'pop':
            self.pop()
        elif com == 'size':
            self.size()
        elif com == 'empty':
            self.empty()
        elif com == 'top':
            self.top()

import sys
n = int(sys.stdin.readline().strip())
answer = []
my_stack = stack()
for i in range(n):
    my_stack.command(list(map(str, sys.stdin.readline().strip().split())))