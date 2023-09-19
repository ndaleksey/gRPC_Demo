package com.nd.client;

import com.nd.grpc.GreetingServiceGrpc;
import com.nd.grpc.GreetingServiceOuterClass;
import io.grpc.ManagedChannelBuilder;

public class ClientApp {
    public static void main(String[] args) {
        var channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();

        var stub = GreetingServiceGrpc.newBlockingStub(channel);
        var request = GreetingServiceOuterClass.HelloRequest.newBuilder()
                .setName("Nick")
                .build();
        var response = stub.greeting(request);

        System.out.println(response);

        channel.shutdownNow();
    }
}
