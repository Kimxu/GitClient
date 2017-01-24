package me.kimxu.gitclient.model.graphql.queries;

import graphql.schema.GraphQLObjectType;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;
import static me.kimxu.gitclient.GraphqlConstants.*;

/**
 * Created by kimxu on 2017/1/24.
 */

public class RepositoryOwnerQueryFull extends GraphqlBaseQuery{

    public static String FIELD_NAME = "repositoryOwner";
    private GraphQLObjectType query;

    public RepositoryOwnerQueryFull() {
        this(DEFAULT_OUTER_ARGUMENT_KEY, DEFAULT_OUTER_ARGUMENT_VAL,
                DEFAULT_INNER_ARGUMENT_KEY, DEFAULT_INNER_ARGUMENT_VAL);
    }

    public RepositoryOwnerQueryFull(String argKey, String argValue, String repositoryArgKey, String repositoryArgVal) {
        query = newObject()
                .name(FIELD_NAME)
                .description(argKey + ":" + argValue)
                .field(newFieldDefinition()     //todo: fill this fields by reflection from fields of RepositoryOwner.class
                        .name("avatarURL")
                        .type(GraphQLString))
                .field(newFieldDefinition()
                        .name("login")
                        .type(GraphQLString))
                .field(newFieldDefinition()
                        .name("path")
                        .type(GraphQLString))
                .field(createEdgedObject(
                        new RepositoryQueryShallow().getQuery(),
                        RepositoryQueryShallow.FIELD_NAME,
                        repositoryArgKey,
                        repositoryArgVal)
                ).build();
    }

    @Override
    public GraphQLObjectType getQuery() {
        return query;
    }

}
