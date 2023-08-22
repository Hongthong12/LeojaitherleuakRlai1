package project_team_melody_is_error.la.leojaitherleuakRlai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_team_melody_is_error.la.leojaitherleuakRlai.model.ChoiceModel;
import project_team_melody_is_error.la.leojaitherleuakRlai.service.ChoiceService;

import java.util.List;
@RestController
@RequestMapping("/choice")
public class ChoiceController {

    @Autowired
    private ChoiceService choiceService;

    public ChoiceController(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }

    @GetMapping("/all")
    public List<ChoiceModel> findAllChoices() {
        return this.choiceService.findAllChoice();
    }
//    @GetMapping("/")
//    public List<Choice> getAllChoices() {
//        return choiceService.getAllChoices();
//    }

    @GetMapping("/{id}")
    public ChoiceModel getBychoiceId(@PathVariable Integer id){
        return this.choiceService.findById(Long.valueOf(id));
    }




}
