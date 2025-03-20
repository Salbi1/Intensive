package com.example.block3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MyTestService {

    @Transactional(
            propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.SERIALIZABLE,
            rollbackFor = RuntimeException.class
    )
    public int method(){
        Random random = new Random();
        int a = random.nextInt(0, 3)+1;
        if(a == 2) {
            return 0;
        }
        return method();
    }
}
