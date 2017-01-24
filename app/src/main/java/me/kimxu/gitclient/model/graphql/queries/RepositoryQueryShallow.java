package me.kimxu.gitclient.model.graphql.queries;

import graphql.schema.GraphQLObjectType;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

/**
 * Created by kimxu on 2017/1/24.
 */

public class RepositoryQueryShallow extends GraphqlBaseQuery {

    public static String FIELD_NAME = "repositories";
    private GraphQLObjectType query;

    public RepositoryQueryShallow() {
        super();
        query = newObject()
                .name(FIELD_NAME)
                .field(newFieldDefinition()
                        .name("name")
                        .type(GraphQLString))
                .field(newFieldDefinition()
                        .name("description")
                        .type(GraphQLString))
                .field(newFieldDefinition()
                        .name("path")
                        .type(GraphQLString))
                .field(newFieldDefinition()
                        .name("homepageURL")
                        .type(GraphQLString))
                .field(newFieldDefinition()
                        .name("forks")
                        .type(createTotalCountObject("forks")))
                .field(newFieldDefinition()
                        .name("watchers")
                        .type(createTotalCountObject("watchers")))
                .field(newFieldDefinition()
                        .name("stargazers")
                        .type(createTotalCountObject("stargazers")))
                .build();
    }


    @Override
    public GraphQLObjectType getQuery() {
        return query;
    }
}
