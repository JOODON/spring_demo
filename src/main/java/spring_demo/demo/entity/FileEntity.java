package spring_demo.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "file")
public class FileEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String originalFileName;

    @Column
    private String storedFileName;

    public static FileEntity toFileEntity(String originalFileName,String storedFileName){
        FileEntity fileEntity=new FileEntity();

        fileEntity.setOriginalFileName(originalFileName);
        fileEntity.setStoredFileName(storedFileName);

        return fileEntity;
    }
}
