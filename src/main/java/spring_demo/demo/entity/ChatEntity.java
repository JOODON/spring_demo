package spring_demo.demo.entity;


import lombok.Data;

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

}
