package spring_demo.demo.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import spring_demo.demo.dto.FileDTO;
import spring_demo.demo.service.FileService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @GetMapping("")
    public String finePage(Model model){
        List<FileDTO> fileDTOS = fileService.fileAllView();
        model.addAttribute("fileDTOS",fileDTOS);
        System.out.println(fileDTOS.get(0).getStoredFileName());
        return "File/filePage";
    }
    @PostMapping("/upload")
    public String fileSave(@ModelAttribute MultipartFile multipartFile) throws IOException {
        if (multipartFile == null){
            System.out.println("파일을 올려주세요");
        }
        else
            fileService.fileSave(multipartFile);

        return "File/filePage";
    }

}
