package com.example.outBox.service;

import com.example.outBox.entity.Message;
import com.example.outBox.entity.OutBox;
import com.example.outBox.repository.MessageRepository;
import com.example.outBox.repository.OutBoxRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendMessage {
    private final MessageRepository messageRepository;
    private final OutBoxRepository outBoxRepository;

    @Transactional
    public void message(String text) {
        Message message = new Message();
        message.setMessage(text);
        messageRepository.save(message);

        OutBox outBox = new OutBox();
        outBox.setOutBuxMessage("OutBox" + text);
        outBoxRepository.save(outBox);
    }
}
