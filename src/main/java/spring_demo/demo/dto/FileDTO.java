package spring_demo.demo.dto;
import lombok.Data;
import spring_demo.demo.entity.FileEntity;

import javax.persistence.*;


@Data
public class FileDTO {

    private Long id;


    private String originalFileName;


    private String storedFileName;

    public static FileDTO fileDTOTo(FileEntity fileEntity){
        FileDTO fileDTO = new FileDTO();
        fileDTO.setId(fileEntity.getId());
        fileDTO.setOriginalFileName(fileEntity.getOriginalFileName());
        fileDTO.setStoredFileName(fileEntity.getStoredFileName());

        return fileDTO;
    }
}
