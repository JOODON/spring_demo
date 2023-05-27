package spring_demo.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_demo.demo.dto.ChatDTO;
import spring_demo.demo.service.ChatService;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatApiController{

    private final ChatService chatService;

    @GetMapping("/new-messages")
    public List<ChatDTO> getNewMessages() {

        return chatService.findAllChat();

    }

}
