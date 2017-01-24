package me.kimxu.gitclient.net;

import graphql.schema.GraphQLObjectType;
import me.kimxu.gitclient.model.GitSearchResult;
import me.kimxu.gitclient.model.graphql.Repository;
import me.kimxu.gitclient.model.graphql.RepositoryOwner;
import me.kimxu.gitclient.model.graphql.core.GraphQLBaseObject;
import me.kimxu.gitclient.model.graphql.core.GraphQLResponseObject;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by kimxu on 2017/1/23.
 */

public class GithubApi {
    private static GithubApi githubApi;
    public ApiManagerService apiManager;

    private GithubApi() {
        String ENDPOINT = "https://api.github.com";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiManager = retrofit.create(ApiManagerService.class);
    }

    public static GithubApi API() {
        if (githubApi == null) {
            synchronized (GithubApi.class) {
                githubApi = new GithubApi();
            }
        }
        return githubApi;
    }


    public interface ApiManagerService {
        @GET("/search/repositories")
        Observable<GitSearchResult> search(
                @Query("q") String q,
                @Query("sort") String sort,
                @Query("order") String order
        );


        @POST("graphql")
        Observable<GraphQLResponseObject<GraphQLBaseObject>> getGraphData(@Body GraphQLObjectType query);

        @POST("graphql")
        Observable<GraphQLResponseObject<RepositoryOwner>> getRepositoryOwner(@Body GraphQLObjectType query);

        @POST("graphql")
        Observable<GraphQLResponseObject<Repository>> getRepository(@Body GraphQLObjectType query);

    }


}
