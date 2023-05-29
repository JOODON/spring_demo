package spring_demo.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import spring_demo.demo.dto.FileDTO;
import spring_demo.demo.entity.FileEntity;
import spring_demo.demo.repository.FileRepository;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository fileRepository;

    public void fileSave(MultipartFile multipartFile) throws IOException {
        String originalFile= multipartFile.getOriginalFilename();
        String storedFileName = System.currentTimeMillis()+originalFile;

        String savePath = "C:/File/"+storedFileName;
        multipartFile.transferTo(new File(savePath));

        FileEntity fileEntity = FileEntity.toFileEntity(originalFile,storedFileName);

        fileRepository.save(fileEntity);
    }
    public List<FileDTO> fileAllView(){
        List<FileEntity> fileEntity = fileRepository.findAll();
        List<FileDTO> fileDTO = new ArrayList<>();


        for (FileEntity f : fileEntity){
            fileDTO.add(FileDTO.fileDTOTo(f));
        }

        return fileDTO;
    }
}
