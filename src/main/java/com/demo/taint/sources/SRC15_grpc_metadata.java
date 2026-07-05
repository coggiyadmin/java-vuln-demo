package com.demo.taint.sources;
import io.grpc.Metadata;
public class SRC15_grpc_metadata {
    public void handle(Metadata headers) throws Exception {
        String cmd = headers.get(Metadata.Key.of("x-cmd", Metadata.ASCII_STRING_MARSHALLER)); // SOURCE
        Runtime.getRuntime().exec("echo " + cmd); // SINK
    }
}
