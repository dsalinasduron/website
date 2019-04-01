def hash():
    N = 13
    M = 11

    key = 197

    hash_value = key % N
    #probe = 1 + (key % M)
    probe = 1
    print 'probe = ' , probe

    for i in range(0,N):
        print hash_value
        hash_value = (hash_value + probe) % N

