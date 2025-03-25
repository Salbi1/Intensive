package com.example.outBox.repository;

import com.example.outBox.entity.Message;
import com.example.outBox.entity.OutBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
