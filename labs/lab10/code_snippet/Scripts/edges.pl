% We must construct these predicates which
% represent the graph
edge(a,b).
edge(a,f).
edge(b,c).
edge(c,d).
edge(c,e).
edge(e,d).
edge(f,g).
edge(f,c).
edge(f,e).
edge(g,c).

% The twoEdge predicate is given for us
twoEdge(N1, N2) :- edge(N1, X), edge(X,N2).

% This predicate uses only the edge predicate
threeEdgeV1(N1, N2) :- edge(N1, X), edge(X,Y), edge(Y,N2).

% This predicate uses the twoEdge and edge predicates
threeEdgeV2(N1, N2) :- twoEdge(N1, X), edge(X,N2).

