package com.nd.server;

import com.nd.grpc.GreetingServiceGrpc;
import com.nd.grpc.GreetingServiceOuterClass;
import io.grpc.stub.StreamObserver;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase{
    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {
        System.out.println(request);

        var response = GreetingServiceOuterClass.HelloResponse.newBuilder()
                .setGreeting("Hello from Server, " + request.getName())
                .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
