package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component("smsService")
public class SmsService implements MessageService{

    @Autowired
    private Properties properties;
    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben SMS Servisiyim...\nSize mesaj gönderiyorum\n"
                + message.getMessage());
        System.out.println("Email : "+ properties.get("email"));
        System.out.println("JAVA_HOME : "+ properties.get("MYJAVA_HOME"));
    }
}
