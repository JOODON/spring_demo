package spring_demo.demo.dto;


import lombok.Getter;
import lombok.Setter;
import spring_demo.demo.config.SecurityUtils;
import spring_demo.demo.entity.ChatEntity;
import spring_demo.demo.entity.ToDoEntity;

@Getter @Setter
public class ChatDTO {
    private Long chatId;

    private String chatName;

    private String chatContent;

    private String chatTime;

    public static ChatDTO toChatDto(ChatEntity chat) {
        ChatDTO chatDTO = new ChatDTO();

        chatDTO.setChatId(chat.getChatId());
        chatDTO.setChatName(chat.getChatName());
        chatDTO.setChatContent(chat.getChatContent());
        chatDTO.setChatTime(chat.getChatTime());

        return chatDTO;
    }
}
