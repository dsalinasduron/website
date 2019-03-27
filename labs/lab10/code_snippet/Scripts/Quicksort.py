"""
Quicksort in Python using list comprehensions

This technique uses the first element in the list as the pivot
"""

def quicksort(l):
    if len(l) <= 1:
        return l
    else:
        smaller = [ x for x in l[1:] if x < l[0] ]
        larger = [ x for x in l[1:] if x >= l[0] ]

        return quicksort(smaller) + [l[0]] + quicksort(larger)
