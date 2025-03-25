package com.example.outBox.service;

import com.example.outBox.entity.OutBox;
import com.example.outBox.repository.OutBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadMessage {
    private final OutBoxRepository outBoxRepository;

    @Scheduled(fixedRate = 2000)
    public void getMessage() {
        List<OutBox> list = outBoxRepository.findAll();
        for(OutBox message : list) {
            System.err.println("Message " + message.getOutBuxMessage());
        }
    }
}
