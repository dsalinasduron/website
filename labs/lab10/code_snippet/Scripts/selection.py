def sort(items):
    
    for i in range(0, len(items) - 1):
        minPosition = i

        for j in range(i + 1, len(items)):
            if items[j] < items[minPosition]:
                minPosition = j

        temp = items[i]
        items[i] = items[minPosition]
        items[minPosition] = temp

    return items
