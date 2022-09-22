package com.example.cultruemates;

import com.example.cultruemates.domain.TestEntity;
import com.example.cultruemates.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestRepository testRepository;
    @GetMapping("/test")
    public ResponseEntity<String> test(){

        TestEntity testEntity = testRepository.findAll().get(0);

        System.out.println(testEntity.getContent());
        return ResponseEntity.ok("테스트 성공");
    }
}
