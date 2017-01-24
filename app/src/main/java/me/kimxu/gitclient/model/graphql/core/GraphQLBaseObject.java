package me.kimxu.gitclient.model.graphql.core;


import java.util.Map;
import java.util.TreeMap;

import me.kimxu.gitclient.model.graphql.annotations.GraphQLType;
import me.kimxu.gitclient.model.graphql.queries.GraphqlBaseQuery;

/**
 * Created by kimxu on 2017/1/24.
 */

@GraphQLType
public abstract class GraphQLBaseObject {

    protected String serializableName;
    protected TreeMap<String, String> argumentMap;
    protected String[] availableArgs;
    protected GraphqlBaseQuery query;



    public GraphQLBaseObject(String serializableName) {
        this.serializableName = serializableName;
    }


    protected final void checkArguments(Map<String, String> arguments) {
        if (arguments == null) {
            return;
        }

        argumentMap = new TreeMap<>();
        for (int i = 0; i < arguments.size(); ++i) {
            if (arguments.containsKey(availableArgs[i])) {
                argumentMap.put(availableArgs[i], arguments.get(availableArgs[i]));
            }
        }

        if (argumentMap.size() == 0) {
            argumentMap.put(availableArgs[0], "1"); //?
        }
    }

    public String getSerializableName() {
        return serializableName;
    }

    public TreeMap<String, String> getArgumentMap() {
        return argumentMap;
    }
}
