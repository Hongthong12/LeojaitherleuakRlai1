package project_team_melody_is_error.la.leojaitherleuakRlai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project_team_melody_is_error.la.leojaitherleuakRlai.model.ResultModel;
import project_team_melody_is_error.la.leojaitherleuakRlai.service.ResultService;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/all")
    public List<ResultModel> findAllResults() {
        return this.resultService.findAllResults();
    }

    @GetMapping("/{id}")
    public ResultModel findResultById(@PathVariable Long id) {
        return this.resultService.findResultById(id);
    }

    @PostMapping("/")
    public ResultModel createResult(@RequestBody ResultModel resultModel) {
        return this.resultService.createResult(resultModel);
    }

}
