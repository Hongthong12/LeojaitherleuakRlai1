package project_team_melody_is_error.la.leojaitherleuakRlai.service;

import jakarta.persistence.EntityNotFoundException;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Account;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Choice;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.History;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Result;
import project_team_melody_is_error.la.leojaitherleuakRlai.model.HistoryModel;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.AccountRepository;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.ChoiceRepository;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.HistoryRepository;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.ResultRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private ChoiceRepository choiceRepository;
    private ChoiceService choiceService;


    //_______________________________________CreateHistory___________________________________________________________


    public History createHistory(Account account, Result result, List<Long> likeChoiceIds, List<Long> disChoiceIds) {
        History history = new History();
        history.setAccount((account));
        history.setResult((result));

        List<Choice> likeChoices = likeChoiceIds.stream()
                .map(choiceId -> choiceRepository.findById(choiceId)
                        .orElseThrow(() -> new EntityNotFoundException("Choice not found with id " + choiceId)))
                .collect(Collectors.toList());
        List<Choice> disChoices = disChoiceIds.stream()
                .map(choiceId -> choiceRepository.findById(choiceId)
                        .orElseThrow(() -> new EntityNotFoundException("Choice not found with id " + choiceId)))
                .collect(Collectors.toList());

        history.setLikeChoices(likeChoices);
        history.setDisChoices(disChoices);
        return historyRepository.save(history);
    }


//    public History createHistory(History history) {
//        return historyRepository.save(history);
//    }


//    public ResponseEntity<String> createHistory(HistoryModel history) {
//        try {
//            historyRepository.save(history);
//            return ResponseEntity.ok("History created successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create history: " + e.getMessage());
//        }
//    }




//    public ResponseEntity<String> createHistory(History history) {
//        Account account = accountRepository.findById(history.getId_account()).orElse(null);
//        Result result = resultRepository.findById(history.getId_Result()).orElse(null);
//        if (account != null && result != null) {
//            history.setAccount(account);
//            history.setResult(result);
//            history.setDateTime(LocalDateTime.now());
//
//            List<Choice> likeChoices = new ArrayList<>();
//            List<Choice> disChoices = new ArrayList<>();
//
//
//            List<Long> likeChoiceIds = new ArrayList<>();
//            for (Choice choice : history.getLikeChoices()) {
//                likeChoiceIds.add((long) choice.getId());
//            }
//            history.setLikeChoiceIds(likeChoiceIds);
//
//            List<Long> disChoiceIds = new ArrayList<>();
//            for (Choice choice : history.getDisChoices()) {
//                disChoiceIds.add((long) choice.getId());
//            }
//            history.setDisChoiceIds(disChoiceIds);
//
//
//            history.setLikeChoices(likeChoices);
//            history.setDisChoices(disChoices);
//
//            History savedHistory = historyRepository.save(history);


//    public List<HistoryModel> findAllHistory() {
//        List<History> histories = this.historyRepository.findAll();
//        List<HistoryModel> models = new ArrayList<>();
//        for (History history : histories) {
//            HistoryModel model = new HistoryModel();
//
//            // Convert choice IDs to ArrayLists of Choice objects
//            List<Integer> likechoice = new ArrayList<>();
//            for (Choice choiceId : history.getLikeChoices()) {
//                int choice = choiceService.findChoiceById(choiceId);
//                likechoice.add(choice);
//            }
//            List<Integer> dischoice = new ArrayList<>();
//            for (Choice choiceId : history.getDisChoices()) {
//                int choice = choiceService.findChoiceById(choiceId);
//                dischoice.add(choice);
//            }
//
//            // Set fields of HistoryModel
//            model.setId(history.getId());
//            model.setDateTime(history.getDateTime());
//            model.setLikechoices((ArrayList<Integer>) likechoice);
//            model.setDischoice((ArrayList<Integer>) dischoice);
//            model.setAccount(history.getAccount());
//            model.setResult(history.getResult());
//
//            models.add(model);
//        }
//
//        return models;
//    }
//
//    public ResponseEntity<String> createHistory(@RequestBody History history) {
//        try {
//            historyRepository.save(history);
//            System.out.println("History created successfully");
//            return new ResponseEntity<>("History created successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            System.out.println("Failed to create history: " + e.getMessage());
//            return new ResponseEntity<>("Failed to create history", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    } else{
//
//            return new ResponseEntity<>("success", HttpStatus.CREATED);
//
//        } else
//
//    {
//        return new ResponseEntity<>("invalid account or result ID", HttpStatus.BAD_REQUEST);
//
//
//    }
//
//    public History saveHistory(History history) {
//
//        return historyRepository.save(history);
//    }

//    __________________________________________________________________________________________________________________


//    _________________________________ดึงข้อมูลประวัติการใช้งานทั้งหมด____________________________________
    public List<History> getAllHistory() {

        return historyRepository.findAll();
    }


    public History createHistory(History history) {
        return historyRepository.save(history);
    }

//  _____________________________________________________________________________________________________________________
//
////    ________________________________ดึงข้อมูลประวัติการใช้งานตาม id_____________________________________________________________
//
//    public History getHistoryById(Long id) {
//    return historyRepository.findById(id).orElse(null);
//}

    public History getHistoryById(Long id) {
        Optional<History> optionalHistory = historyRepository.findById(id);
        if (optionalHistory.isPresent()) {
            History history = optionalHistory.get();
            if (history.isDeleted()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This ID has been deleted.");
            }
            return history;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This ID does not exist.");
        }
    }
////________________________________________________________________________________________________________________________
//
//
////    ________________________________ลบข้อมูลประวัติการใช้งาน___________________________________________________________________

    public ResponseEntity<String> deleteHistory(Long historyId) {
        Optional<History> historyOptional = historyRepository.findById(historyId);
        if (historyOptional.isPresent()) {
            History history = historyOptional.get();
            if (!history.isDeleted()) {
                history.setDeleted(true);
                historyRepository.save(history);
                return new ResponseEntity<>("History has been marked as deleted successfully.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("History has already been deleted.", HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>("History not found.", HttpStatus.NOT_FOUND);
        }
    }

//    ____________________________________________________________________________________________________________________
}
