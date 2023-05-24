package spring_demo.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring_demo.demo.config.SecurityUtils;
import spring_demo.demo.dto.BoardDTO;
import spring_demo.demo.dto.MemberFormDTO;
import spring_demo.demo.dto.ToDoDTO;
import spring_demo.demo.entity.MemberEntity;
import spring_demo.demo.service.MemberService;
import spring_demo.demo.service.ToDoService;

import javax.swing.plaf.PanelUI;
import java.lang.ref.PhantomReference;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Todo")
public class ToDoController {
    private final ToDoService toDoService;

    private final MemberService memberService;
    @GetMapping
    public String todoView(Model model) {
        MemberEntity member= memberService.findByMember(SecurityUtils.getCurrentUserId());

        List<ToDoDTO> toDoDTOList = toDoService.toDoDTOListByMemberId(member.getId());

        model.addAttribute("toDoDTOList", toDoDTOList);

        model.addAttribute("currentUser", SecurityUtils.getCurrentUserId());

        return "ToDo/ToDoView";
    }

    @PostMapping("/write")
    public ResponseEntity<List<ToDoDTO>> todoWrite(@ModelAttribute ToDoDTO toDoDTO) {
        toDoService.save(toDoDTO);

        MemberEntity member= memberService.findByMember(SecurityUtils.getCurrentUserId());

        List<ToDoDTO> toDoDTOList = toDoService.toDoDTOListByMemberId(member.getId());

        return new ResponseEntity<>(toDoDTOList, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public String todoDelete(Long id){
        toDoService.deleteById(id);

        return "ToDo/ToDoView";
    }
}
