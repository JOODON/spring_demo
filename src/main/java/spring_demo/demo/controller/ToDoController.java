package spring_demo.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring_demo.demo.dto.ToDoDTO;
import spring_demo.demo.service.ToDoService;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;
    @GetMapping("/Todo")
    public String todoView(Model model){
        List<ToDoDTO> toDoDTOList= toDoService.toDoDTOList();
        model.addAttribute("toDoDTOList",toDoDTOList);

        return "ToDo/ToDoView";
    }
}
