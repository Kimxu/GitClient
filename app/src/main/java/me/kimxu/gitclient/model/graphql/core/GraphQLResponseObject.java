package me.kimxu.gitclient.model.graphql.core;

import com.google.gson.annotations.SerializedName;

import me.kimxu.gitclient.GraphqlConstants;
import me.kimxu.gitclient.model.graphql.annotations.GraphQLType;


/**
 * Created by kimxu on 2017/1/24.
 */
@GraphQLType
public class GraphQLResponseObject<T extends GraphQLBaseObject> extends GraphQLBaseObject {

    private GraphQLDataObject<T> data;

    public GraphQLResponseObject() {
        super(GraphqlConstants.NAME_BLANK);
    }

    public GraphQLDataObject<T> getData() {
        return data;
    }

    public T getObject() {
        return data.object;
    }


    public class GraphQLDataObject<T extends GraphQLBaseObject> extends GraphQLBaseObject {
        public GraphQLDataObject() {
            super(GraphqlConstants.NAME_BLANK);
        }
        @SerializedName(
                value = GraphqlConstants.NAME_REPOSITORY_OWNER,
                alternate = {GraphqlConstants.NAME_REPOSITORIES, GraphqlConstants.NAME_REPOSITORY, GraphqlConstants.NAME_VIEWER})
        private T object;

    }

}
