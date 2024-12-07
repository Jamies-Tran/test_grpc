package com.example.demo.service;

import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;
import src.main.proto.GreetingWorldGrpc;
import src.main.proto.TestModel;

@Service
public class Greeting extends GreetingWorldGrpc.GreetingWorldImplBase {
    @Override
    public void greet(TestModel.Model request, StreamObserver<TestModel.Result> responseObserver) {
        String hello = "Hello World! from %s".formatted(request.getName());
        responseObserver.onNext(TestModel.Result.newBuilder().setResult(hello).build());
        responseObserver.onCompleted();
    }
}
