package spring_demo.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring_demo.demo.dto.BoardDTO;
import spring_demo.demo.dto.ToDoDTO;
import spring_demo.demo.service.ToDoService;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Todo")
public class ToDoController {
    private final ToDoService toDoService;
    @GetMapping
    public String todoView(Model model){
        List<ToDoDTO> toDoDTOList= toDoService.toDoDTOList();
        model.addAttribute("toDoDTOList",toDoDTOList);

        return "ToDo/ToDoView";
    }
    @PostMapping("/write")
    public ResponseEntity  todoWrite(@ModelAttribute ToDoDTO toDoDTO){
        toDoService.save(toDoDTO);
        List<ToDoDTO> toDoDTOList= toDoService.toDoDTOList();

        return new ResponseEntity<>(toDoDTOList , HttpStatus.OK);
    }
}
