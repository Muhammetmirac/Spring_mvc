package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component("smsService")
public class SmsService implements MessageService{
    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben SMS Servisiyim...\nSize mesaj gönderiyorum\n"
                + message.getMessage());
    }
}
