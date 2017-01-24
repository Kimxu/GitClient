package me.kimxu.gitclient.model.graphql;

import android.support.annotation.Nullable;


import java.util.LinkedHashMap;

import me.kimxu.gitclient.model.graphql.core.GraphQLBaseObject;
import me.kimxu.gitclient.model.graphql.core.GraphQLGraphObject;

import static me.kimxu.gitclient.GraphqlConstants.*;


/**
 *
 * Created by kimxu on 2017/1/24.
 */
public class Repository extends GraphQLBaseObject {

    public Repository(@Nullable LinkedHashMap<String, String> args) {
        super(NAME_REPOSITORY);
        super.availableArgs = new String[]{
                ARGUMENT_FIRST,
                ARGUMENT_AFTER,
                ARGUMENT_LAST,
                ARGUMENT_BEFORE,
                ARGUMENT_PRIVACY,
                ARGUMENT_ISFORK,
                ARGUMENT_ORDERBY,
        };
        checkArguments(args);
    }

    public Repository() {
        this(null);
    }


    private String description;
    private String homepageURL;
    private String name;
    private String path;


    private GraphQLGraphObject<Repository> forks;
    private GraphQLGraphObject<PullRequest> pullRequests;
    private GraphQLGraphObject<User>        stargazers;
    private GraphQLGraphObject<User>        watchers;


    public String[] getAvailableArgs() {
        return availableArgs;
    }

    public String getDescription() {
        return description;
    }

    public String getHomepageURL() {
        return homepageURL;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public GraphQLGraphObject<Repository> getForks() {
        return forks;
    }

    public GraphQLGraphObject<PullRequest> getPullRequests() {
        return pullRequests;
    }

    public GraphQLGraphObject<User> getStargazers() {
        return stargazers;
    }

    public GraphQLGraphObject<User> getWatchers() {
        return watchers;
    }
}
