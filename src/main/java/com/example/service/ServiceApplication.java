package com.example.service;

import com.example.service.proto.HelloReply;
import com.example.service.proto.HelloRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.service.proto.SimpleGrpc;

@SpringBootApplication
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

}


@GrpcService
class GrpcServerService extends SimpleGrpc.SimpleImplBase {

	@Override
	public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
		HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}

}