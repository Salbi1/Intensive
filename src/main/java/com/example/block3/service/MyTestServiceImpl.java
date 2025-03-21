package com.example.block3.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor_ = @__(@Lazy))
@Slf4j
public class MyTestServiceImpl implements MyTestService{
    private final MyTestServiceImpl myTestService;

    @Override
    @Transactional(
            propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.SERIALIZABLE,
            rollbackFor = RuntimeException.class
    )
    public void method(int count){
        if(count <= 0) {
            return ;
        }

        myTestService.method(count - 1);
    }
}
