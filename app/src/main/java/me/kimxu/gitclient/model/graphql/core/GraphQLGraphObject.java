package me.kimxu.gitclient.model.graphql.core;


import java.util.List;

import me.kimxu.gitclient.model.graphql.annotations.GraphQLType;

/**
 * Created by kimxu on 2017/1/24.
 */

@GraphQLType
public class GraphQLGraphObject<T extends GraphQLBaseObject> {

    private List<GraphQLEdgeObject<T>> edges;
    private int totalCount;

    public List<GraphQLEdgeObject<T>> getEdges() {
        return edges;
    }

    public int getTotalCount() {
        return totalCount;
    }

}
