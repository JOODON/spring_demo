package spring_demo.demo.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring_demo.demo.dto.BoardDTO;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name = "boardTable")
public class BoardEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    private String content;

    @NotNull
    private String name;


    public static BoardEntity toBoardEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity=new BoardEntity();
        boardEntity.setTitle(boardDTO.getTitle());
        boardEntity.setContent(boardDTO.getContent());
        boardEntity.setName(boardDTO.getName());
        boardEntity.setCreateDataTime(boardDTO.getCreateDataTime());
        boardEntity.setUpdatedTime(boardDTO.getUpdatedTime());
        return boardEntity;
    }
}
