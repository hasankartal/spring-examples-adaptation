package com.haydikodlayalim.aop.api;

import com.haydikodlayalim.aop.service.MessageService;
import com.haydikodlayalim.aop.service.SecondMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageApi {
    @Autowired
    private MessageService messageService;

    @Autowired
    private SecondMessageService secondMessageService;

    @PostMapping //http://localhost:8041/message -> Post
    public ResponseEntity<String> ornekMethod(@RequestBody String message) {
        secondMessageService.mesaj(message);
        return ResponseEntity.ok(messageService.mesajVer(message));
    }
}
