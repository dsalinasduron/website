'''
state - the state of the game being evaluated
level - determines what level being evaluated where

    Max: level % 2 == 0
    Min: level % 2 != 0
'''
def minimax(state, level):
    '''
    If we are at a terminal state, return the
    utility (value) of the state. This may be a
    simple +1/0/-1 representing whether the terminal
    state is a win, draw, or loss.
    '''
    if terminalTest(state):
        return utility(state)
    else:
        if level % 2 == 0:  # max node
            max = float("-inf")
            for s in successors(state):
                temp = minimax(s,level+1)
                if temp > max:
                    max = temp

            return max
        else:               # min node
            min = float("inf")
            for s in successors(state):
                temp = minimax(s,level+1)
                if temp < min:
                    min = temp

            return min
