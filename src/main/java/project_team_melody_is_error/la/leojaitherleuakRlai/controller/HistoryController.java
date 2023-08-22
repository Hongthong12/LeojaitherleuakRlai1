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

@RestController
@RequestMapping("/api")
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




//____________________________________________เพิ่มข้อมูลประวัติการใช้งาน___________________________________________________________________


//    @PostMapping("/history")
//    public ResponseEntity<ResponseEntity<String>> createHistory(@RequestBody History history) {
//    ResponseEntity<String> history = historyService.createHistory(history);
//    return ResponseEntity.ok(history);
//}




    @PostMapping("/history")
    public ResponseEntity<History> createHistory(@RequestBody HistoryModel model) {
        History history = new History(model.getDateTime(), model.getAccountId(), model.getResultId(), model.getLikeChoiceIds(), model.getDisChoiceIds());
        History savedHistory = historyService.createHistory(history);
        return new ResponseEntity<>(savedHistory, HttpStatus.CREATED);
    }







//    @PostMapping("/post")
//    public ResponseEntity<History> saveHistory(@RequestBody History history) {
//        History savedHistory = historyService.saveHistory(history);
//        return new ResponseEntity<>(savedHistory, HttpStatus.CREATED);
//
//    }

//    @PostMapping("/history")
//    public ResponseEntity<?> createHistory(@RequestBody HistoryModel historyModel) {
//        // สร้างอ็อบเจ็กต์ History จากข้อมูลใน historyModel
//        History history = new History();
//        history.setDateTime(historyModel.getDateTime());
//        // ทำการแปลง ArrayList ของ Integer เป็น ArrayList ของ Choice ก่อนจะกำหนดให้กับ likeChoices และ disChoices ของ history
//        Set<Choice> likeChoicesList = new HashSet<>();
//        for (Integer choiceId : historyModel.getLikechoices()) {
//            Choice choice = choiceService.findChoiceById(choiceId);
//            likeChoicesList.add(choice);
//        }
//        history.setLikeChoicesList(likeChoicesList);
//
//        Set<Choice> disChoicesList = new HashSet<>();
//        for (Integer choiceId : historyModel.getDischoice()) {
//            Choice choice = choiceService.findChoiceById(choiceId);
//            disChoicesList.add(choice);
//        }
//        history.setDisChoicesList(disChoicesList);
//
//        history.setAccount(historyModel.getAccount());
//        history.setResult(historyModel.getResult());
//
//        try {
//            historyRepository.save(history);
//            System.out.println("History created successfully");
//            return ResponseEntity.ok("History created successfully");
//        } catch (Exception e) {
//            System.out.println("Failed to create history: " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create history");
//        }
//    }
////______________________________________________________________________________________________________________________


    //    ________________________________________________________ดึงข้อมูลประวัติการใช้งานทั้งหมด____________________________________________
//    @GetMapping("/")
//    public List<History> getAllHistory() {
//        return historyService.getAllHistory();
//    }

//    ______________________________________________________________________________________________________________________


//_________________________________________ดึงข้อมูลประวัติการใช้งานตาม id__________________________________________



//    @GetMapping("/{id}")
//    public ResponseEntity<History> getHistoryById(@PathVariable Long id) {
//        History history = historyService.getHistoryById(id);
//        if (history != null) {
//            return ResponseEntity.ok(history);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHistoryById(@PathVariable Long id) {
        try {
            History history = historyService.getHistoryById(id);
            return ResponseEntity.ok(history);
        } catch (ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
        }
    }
//    ___________________________________________________________________________________________________________________


//_______________________________________ อัพเดตข้อมูลประวัติการใช้งาน__ยังใช้ไม่ได้___________________________________________________________


//    @PutMapping("/{id}")
//    public ResponseEntity<History> updateHistory(@PathVariable(value = "id") Long historyId,
//                                                 @RequestBody History historyDetails) {
//        History history = historyRepository.findById(historyId).orElse(null);
//        if (history == null) {
//            return ResponseEntity.notFound().build();
//        }
//        history.getDateTime(history.getDateTime());
//        history.setAccount(historyDetails.getAccount());
//        history.setResult(historyDetails.getResult());
//
//        History updatedHistory = historyRepository.save(history);
//        return ResponseEntity.ok(updatedHistory);
//    }

//_______________________________________ลบข้อมูลประวัติการใช้งาน_______________________________________________________________


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHistory(@PathVariable(value = "id") Long historyId) {
        return historyService.deleteHistory(historyId);
    }

//________________________________________________________________________________________________________________________


}