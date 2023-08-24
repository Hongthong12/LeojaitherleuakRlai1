package project_team_melody_is_error.la.leojaitherleuakRlai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.History;
import project_team_melody_is_error.la.leojaitherleuakRlai.model.HistoryModel;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.AccountRepository;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.HistoryRepository;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.ResultRepository;
import project_team_melody_is_error.la.leojaitherleuakRlai.service.AccountService;
import project_team_melody_is_error.la.leojaitherleuakRlai.service.ChoiceService;
import project_team_melody_is_error.la.leojaitherleuakRlai.service.HistoryService;
import project_team_melody_is_error.la.leojaitherleuakRlai.service.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class HistoryController {

    @Autowired
    private HistoryService historyService;
    private HistoryRepository historyRepository;

    @Autowired
    private AccountService accountService;
    private AccountRepository accountRepository;
    private ChoiceService choiceService;

    @Autowired
    private ResultRepository resultRepository;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }




//____________________________________________เพิ่มข้อมูลประวัติการใช้งาน________________________________________________________


    @PostMapping("/history")
    public ResponseEntity<String> createHistory(@RequestBody HistoryModel historyModel) {
        try {
            History history = historyService.createHistory(historyModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Success");
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unsuccess");
        }
    }



//______________________________________________________________________________________________________________________


    //    ________________________________________________________ดึงข้อมูลประวัติการใช้งานทั้งหมด________________________________
    @GetMapping("/")
    public List<HistoryModel> getAllHistory() {
        return historyService.findAllHistory();
    }
//    __________________________________________________________________________________________________________________


//_________________________________________ดึงข้อมูลประวัติการใช้งานตาม id______________________________________________________



    @GetMapping("/{id}")
    public HistoryModel getHistoryById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return historyService.getHistoryById(id);
    }


//    __________________________________________________________________________________________________________________


//_______________________________________ อัพเดตข้อมูลประวัติการใช้งาน__ยังใช้ไม่ได้_________________________________________________



//    @PutMapping("/{id}")
//    public ResponseEntity<History> updateHistory(@PathVariable(value = "id") Long historyId,
//                                                 @RequestBody HistoryModel model) {
//        History updatedHistory = historyService.updateHistory(historyId, model);
//        if (updatedHistory != null) {
//            return ResponseEntity.ok(updatedHistory);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }


//_______________________________________ลบข้อมูลประวัติการใช้งาน______________________________________________________________


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHistory(@PathVariable(value = "id") Long historyId) {
        return historyService.deleteHistory(historyId);
    }

//______________________________________________________________________________________________________________________


}