def largest(list, first, last):
    if first == last:
        biggest = list[first]
    else:
        mid = (first + last) / 2

        maxLeft = max(list, first, mid)
        maxRight = max(list, mid+1, last)

        if maxLeft > maxRight:
            biggest = maxLeft
        else:
            biggest = maxRight

    return biggest
