package com.demo.taint.sources;
import graphql.schema.DataFetchingEnvironment;
public class SRC16_graphql_var {
    public Object run(DataFetchingEnvironment env) throws Exception {
        String cmd = env.getArgument("cmd"); // SOURCE graphql variable
        Runtime.getRuntime().exec("echo " + cmd); // SINK
        return null;
    }
}
