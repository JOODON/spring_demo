package spring_demo.demo.entity;


import lombok.Data;
import spring_demo.demo.config.SecurityUtils;
import spring_demo.demo.dto.ChatDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CHAT")
@Data
public class ChatEntity {
    @Id
    @GeneratedValue
    private Long chatId;

    private String chatName;

    private String chatContent;

    private String chatTime;

    public static ChatEntity toChatEntity(ChatDTO chatDTO) {
        ChatEntity chat = new ChatEntity();

        chat.setChatContent(chatDTO.getChatContent());
        chat.setChatName(SecurityUtils.getCurrentUserId());
        chat.setChatTime(chatDTO.getChatTime());

        return chat;
    }
}
