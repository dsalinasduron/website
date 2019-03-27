'''
Implementation of Horner's algorithm
for evaluating a polynomial.

P represents a list of coefficients
x represents the value of x being evaluated 
for the  polynomial.

i.e. For a polynomial 2x^4 -x^3 + 3x^2 + x - 5
P = [2, -1, 3, 1, -5]

@author Greg Gagne October 2014
'''

def horner(P, x):
    # get the last element in the list P
    p = P[0]

    '''
    apply horners from element [1] to
    the end of the list
    '''
    for v in P[1:]:
        p = x * p + v

    return p

