package me.kimxu.gitclient.model.graphql.core;


import me.kimxu.gitclient.GraphqlConstants;
import me.kimxu.gitclient.model.graphql.annotations.GraphQLType;

/**
 * Created by kimxu on 2017/1/24.
 */
@GraphQLType
public class GraphQLEdgeObject<T extends GraphQLBaseObject> extends GraphQLBaseObject{

    public GraphQLEdgeObject() {
        super(GraphqlConstants.NAME_BLANK);
    }

    @GraphQLType
    private T node;

    public T getNode() {
        return node;
    }
}
