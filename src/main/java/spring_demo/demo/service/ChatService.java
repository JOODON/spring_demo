package spring_demo.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring_demo.demo.dto.ChatDTO;
import spring_demo.demo.entity.ChatEntity;
import spring_demo.demo.repository.ChatRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public List<ChatDTO> findAllChat(){
        List<ChatDTO> chatDTOS = new ArrayList<>();

        List<ChatEntity> chatEntity = chatRepository.findAll();
        for (ChatEntity chat : chatEntity){
            ChatDTO chatDTO = ChatDTO.toChatDto(chat);
            chatDTOS.add(chatDTO);
        }

        return chatDTOS;
    }


}