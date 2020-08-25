class bicluster:
    def __init__(self, vec, left=None, right=None, distance=0.0, id=None):
        self.left = left
        self.right = right
        self.vec = vec
        self.id = id
        self.distance = distance


def hcluster(rows, distance):
    distances = {}
    currentclustid = -1
    # Clusters are initially just the rows
    clust = [bicluster(rows[i], id=i) for i in range(len(rows))]
    while len(clust) > 1:
        lowestpair = (0, 1)
        closest = distance(clust[0].vec, clust[1].vec)
    # loop through every pair looking for the smallest distance
        for i in range(len(clust)):
            for j in range(i+1, len(clust)):
                # distances is the cache of distance calculations
                if(clust[i].id, clust[j].id) not in distances:
                    distances[(clust[i].id, clust[j].id)] = distance(
                        clust[i].vec, clust[j].vec)
                    d = distances[(clust[i].id, clust[j].id)]
                if d < closest:
                    closest = d
                    lowestpair = (i, j)
    # calculate the average of the two clusters
    mergevec = [
        (clust[lowestpair[0]].vec[i]+clust[lowestpair[1]].vec[i])/2.0
        for i in range(len(clust[0].vec))]
    # create the new cluster
    newcluster = bicluster(mergevec, left=clust[lowestpair[0]],
                           right=clust[lowestpair[1]],
                           distance=closest, id=currentclustid)
    # cluster ids that weren't in the original set are negative
    currentclustid -= 1
    del clust[lowestpair[1]]
    del clust[lowestpair[0]]
    clust.append(newcluster)
    return clust[0]


def printclust(clust, labels=None, n=0):
    # indent to make a hierarchy layout
    for i in range(n):
        print(''),
    if clust.id < 0:
        # negative id means that this is branch
        print('-')
    else:
        # positive id means that this is an endpoint
        if labels == None:
            print(clust.id)
        else:
            print(labels[clust.id])
    # now print the right and left branches
    if clust.left != None:
        printclust(clust.left, labels=labels, n=n+1)
    if clust.right != None:
        printclust(clust.right, labels=labels, n=n+1)
