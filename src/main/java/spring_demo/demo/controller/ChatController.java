package spring_demo.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring_demo.demo.dto.ChatDTO;
import spring_demo.demo.service.ChatService;

import java.util.List;

@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;
    @GetMapping("")
    public String showChatList(Model model){
        List<ChatDTO> chatDTOS = chatService.findAllChat();

        model.addAttribute("chatDTOS",chatDTOS);

        return "openChat";
    }


    @PostMapping("/write")
    public String draftMessage(@ModelAttribute ChatDTO chatDTO){

        chatService.chatSave(chatDTO);

        return "openChat";
    }
}
