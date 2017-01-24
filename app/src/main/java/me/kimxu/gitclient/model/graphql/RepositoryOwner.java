package me.kimxu.gitclient.model.graphql;

import android.support.annotation.Nullable;


import java.util.LinkedHashMap;

import me.kimxu.gitclient.model.graphql.annotations.GraphQLDontFetch;
import me.kimxu.gitclient.model.graphql.annotations.GraphQLRestrictDepth;
import me.kimxu.gitclient.model.graphql.core.GraphQLBaseObject;
import me.kimxu.gitclient.model.graphql.core.GraphQLGraphObject;

import static me.kimxu.gitclient.GraphqlConstants.*;


/**
 * Created by kimxu on 2017/1/24.
 */

public class RepositoryOwner extends GraphQLBaseObject {

    public RepositoryOwner(@Nullable LinkedHashMap<String, String> args) {
        super(NAME_REPOSITORY_OWNER);
        super.availableArgs = new String[] {
                ARGUMENT_LOGIN
        };
        checkArguments(args);
        repositories = new GraphQLGraphObject<>();
    }

    public RepositoryOwner(){
        this(null);
    }

    private String avatarURL;
    private String login;
    private String path;

    @GraphQLRestrictDepth(maxLevel = 2)
    private GraphQLGraphObject<Repository> repositories;

    @GraphQLDontFetch
    private Repository repository;


    public String getAvatarURL() {
        return avatarURL;
    }

    public String getLogin() {
        return login;
    }

    public String getPath() {
        return path;
    }

    public GraphQLGraphObject<Repository> getRepositories() {
        return repositories;
    }

    public Repository getRepository() {
        return repository;
    }


}
