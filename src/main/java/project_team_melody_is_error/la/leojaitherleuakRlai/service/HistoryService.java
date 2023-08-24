package project_team_melody_is_error.la.leojaitherleuakRlai.service;

import jakarta.persistence.EntityNotFoundException;

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

import java.time.LocalDateTime;
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

    public History createHistory(HistoryModel historyModel) throws ResourceNotFoundException {
        History history = new History();
        history.setDateTime(LocalDateTime.now());
        history.setDeleted(historyModel.isDeleted()); // set isDeleted

        // get account by accountId
        Account account = accountRepository.findById(historyModel.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + historyModel.getAccountId()));
        history.setAccount(account);

        // get result by resultId
        Result result = resultRepository.findById(historyModel.getResultId())
                .orElseThrow(() -> new ResourceNotFoundException("Result not found for this id :: " + historyModel.getResultId()));
        history.setResult(result);

        // get likeChoices by choiceIds
        List<Long> likeChoiceIds = historyModel.getLikeChoices();
        List<Choice> likeChoices = choiceRepository.findAllById(likeChoiceIds);
        history.setLikeChoices(likeChoices);

        // get disChoices by choiceIds
        List<Long> disChoiceIds = historyModel.getDisChoices();
        List<Choice> disChoices = choiceRepository.findAllById(disChoiceIds);
        history.setDisChoices(disChoices);

        return historyRepository.save(history);
    }

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

    public List<HistoryModel> findAllHistory() {
        List<History> dataList = this.historyRepository.findAll();
        List<HistoryModel> result = new ArrayList<>();
        for (History d : dataList) {
            HistoryModel x = new HistoryModel();
            x.setDateTime(d.getDateTime());
            x.setAccountId(d.getAccount().getId());
            x.setResultId(d.getResult().getId());
            x.setLikeChoices(d.getLikeChoices().stream().map(Choice::getId).collect(Collectors.toList()));
            x.setDisChoices(d.getDisChoices().stream().map(Choice::getId).collect(Collectors.toList()));
            x.setDeleted(d.isDeleted());
            x.setAccount(d.getAccount());
            x.setResult(d.getResult());
            result.add(x);
        }
        return result;
    }





//    public List<History> getAllHistory() {
//
//        return historyRepository.findAll();
//    }
//
//
//    public History createHistory(History history) {
//
//        return historyRepository.save(history);
//    }

//  ____________________________________________________________________________________________________________________

//__________________________________________   PUT history      ________________________________________________________


//    public History updateHistory(Long id, HistoryModel model) {
//        Optional<History> optionalHistory = historyRepository.findById(id);
//        if (optionalHistory.isPresent()) {
//            History history = optionalHistory.get();
//            history.setDateTime(model.getDateTime());
//            history.setAccount(model.getAccount());
//            history.setResult(model.getResult());
//            history.setLikeChoices(model.getLikeChoices());
//            history.setDisChoice(model.getDisChoice());
//            return historyRepository.save(history);
//        } else {
//            return null;
//        }
//    }



//    ____________________________________________________________________________________________________________________

//
////    ________________________________ดึงข้อมูลประวัติการใช้งานตาม id_________________________________________________________
//
//    public History getHistoryById(Long id) {
//    return historyRepository.findById(id).orElse(null);
//}

    public HistoryModel getHistoryById(Long id) throws ResourceNotFoundException {
        History history = historyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("History not found for this id :: " + id));
        HistoryModel historyModel = new HistoryModel();
        historyModel.setDateTime(history.getDateTime());
        historyModel.setAccountId(history.getAccount().getId());
        historyModel.setResultId(history.getResult().getId());
        historyModel.setLikeChoices(history.getLikeChoices().stream().map(Choice::getId).collect(Collectors.toList()));
        historyModel.setDisChoices(history.getDisChoices().stream().map(Choice::getId).collect(Collectors.toList()));
        historyModel.setDeleted(history.isDeleted());
        historyModel.setAccount(history.getAccount());
        historyModel.setResult(history.getResult());
        return historyModel;
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
