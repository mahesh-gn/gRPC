package com.insp.NotificationManagement.service;

import com.insp.NotificationManagement.model.Notification;
import com.proto.NotificationRequest;
import com.proto.NotificationResponse;
import com.proto.StudentNotificationServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class NotificationServer extends StudentNotificationServiceGrpc.StudentNotificationServiceImplBase
{
    Logger log = LoggerFactory.getLogger(NotificationServer.class);
    @Autowired
    private NotificationService notificationService;
    @Override
    public void getNotificationById(NotificationRequest request, StreamObserver<NotificationResponse> responseObserver) {

        int notificationId = request.getNotificationId();
        Notification notification = notificationService.getNotificationById(notificationId);
        if(notification==null)
        {
            log.info("Notification doesn't exist");
        }
        else
        {
            log.info(notification.getNotificationId()+"");
        }
        NotificationResponse response = NotificationResponse.newBuilder().setNotificationId(notification.getNotificationId())
                .setStudentName(notification.getPayload().getStudentName()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
