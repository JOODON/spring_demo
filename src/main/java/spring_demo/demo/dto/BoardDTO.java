package spring_demo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import spring_demo.demo.entity.BoardEntity;

@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO extends BaseDTO{
    private Long id;

    private String title;

    private String content;

    private String name;

    public static BoardDTO toBoardDTO(BoardEntity boardEntity){
        BoardDTO boardDTO=new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setTitle(boardEntity.getTitle());
        boardDTO.setContent(boardEntity.getContent());
        boardDTO.setName(boardEntity.getName());
        boardDTO.setUpdatedTime(boardEntity.getUpdatedTime());
        boardDTO.setCreateDataTime(boardEntity.getCreateDataTime());
        return boardDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
