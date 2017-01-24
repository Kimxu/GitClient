package me.kimxu.gitclient.model.graphql;


import me.kimxu.gitclient.GraphqlConstants;
import me.kimxu.gitclient.model.graphql.core.GraphQLBaseObject;

/**
 * Created by kimxu on 2017/1/24.
 */
public class PullRequest extends GraphQLBaseObject {

    public PullRequest() {
        super(GraphqlConstants.NAME_BLANK);
    }

}
