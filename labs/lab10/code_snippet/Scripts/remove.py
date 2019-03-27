# remove item from subtree
remove(item, subtree):

    if subtree == null
        return null
    else
        if item < subtree.data
            # go left
            
            left = remove(item, subtree.leftchild)

            subtree.leftchild = left
        else if item > subtree.data
            # go right

            right = remove(item, subtree.rightchild)

            subtree.rightchild = right
        else if subtree.leftchild != null &&
                            subtree.rightchild != null

            # 2 children

            # get the leftmost child of the right subtree
            # and copy it to the node we are deleting
            successor = leftmost(subtree.rightchild)

            subtree.data = successor.data

            # now remove the leftmost child of the right subtree

            right = remove(successor.data, subtree.rightchild)

            # set the right child of the subtree to this new subtree

            subtree.rightchild = right
        else
            # 1 or 0 children

            if subtree.leftchild != null
                subtree = subtree.leftchild
            else
                subtree = subtree.rightchild


        return subtree


