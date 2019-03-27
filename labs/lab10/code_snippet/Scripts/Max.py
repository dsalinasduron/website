"""
Returns the maximum element in list l
"""

def max(l):
    len = len(l)

    if len == 1:
        return l
    else:
        '''
        obtain the maximum in the left side of the list
        '''
        maxLeft = max(l[0:len/2])
        '''
        obtain the maximum in the right side of the list
        '''
        maxRight = max(l[len/2 + 1:])

        if maxLeft > maxRight:
            return maxLeft
        else:
            return maxRight
