package project_team_melody_is_error.la.leojaitherleuakRlai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Choice;
import project_team_melody_is_error.la.leojaitherleuakRlai.model.ChoiceModel;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.ChoiceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChoiceService {

    @Autowired
    private ChoiceRepository choiceRepository;

    public ChoiceService(ChoiceRepository choiceRepository) {
        this.choiceRepository = choiceRepository;
    }


//    public Choice getChoiceById(Integer id) {
//        return choiceRepository.findById(id).orElse(null);
//    }

    //
//    _____________________________________GetAll____________________________________________________________
    public List<ChoiceModel> findAllChoice() {

        List<Choice> dataList = this.choiceRepository.findAll();
        List<ChoiceModel> result = new ArrayList<>();
        for ( Choice d: dataList) {
            ChoiceModel x = new ChoiceModel();
            x.setId(Math.toIntExact(d.getId()));
            x.setChoiceEng(d.getChoiceEng());
            x.setChoiceThai(d.getChoiceThai());
            x.setNameChoice(d.getNameChoice());
            x.setNameEng(d.getNameEng());
            x.setResult(d.getResult());
            result.add(x);
        }
        return result;
    }

//    __________________________________________________________________________________________________________


    //    ________________________________________GetOneId_____________________________________________________________
    public ChoiceModel findById(Long id) {
        Optional<Choice> optionalChoice = this.choiceRepository.findById(id);
        if (optionalChoice.isPresent()){
            Choice d = optionalChoice.get();
            ChoiceModel x = new ChoiceModel();
            x.setId(Math.toIntExact(d.getId()));
            x.setChoiceEng(d.getChoiceEng());
            x.setChoiceThai(d.getChoiceThai());
            x.setNameChoice(d.getNameChoice());
            x.setNameEng(d.getNameEng());
            x.setResult(d.getResult());
            return x;
        }else {
            return null;
        }
    }
//_____________________________________________________________________________________________________________________

//    public Long getIdChoiceByName(String nameChoice) {
//        return choiceRepository.getId_choice(nameChoice);
//    }

//    public String calculateResult(List<Choice> choices,int totalChoices,int selectedChoices){
//        if (totalChoices != 10 || selectedChoices != 5) {
//            throw new IllegalArgumentException("totalChoices must be 10 and selectedChoices must be 5");
//        }
//        // นับจำนวนตามเงื่อนไข
//        int bullCount = 0;
//        int ratCount = 0;
//        int bearCount = 0;
//        int eagleCount = 0;
//        Long resultId = null;
//
//        for (Choice choice : choices) {
//            if (choice.getName_choice().equals("bull")) {
//                bullCount++;
//            } else if (choice.getName_choice().equals("rat")) {
//                ratCount++;
//            } else if (choice.getName_choice().equals("bear")) {
//                bearCount++;
//            } else if (choice.getName_choice().equals("eagle")) {
//                eagleCount++;
//            }
//        }
//
//        // ลบจำนวนตามเงื่อนไข
//        bullCount -= (totalChoices - selectedChoices) * 2;
//        ratCount -= (totalChoices - selectedChoices);
//        bearCount -= (totalChoices - selectedChoices);
//        eagleCount -= (totalChoices - selectedChoices);
//
//        // หาผลลัพธ์ที่มีค่ามากที่สุด
//        int maxCount = Math.max(Math.max(bullCount, ratCount), Math.max(bearCount, eagleCount));
//        String resultCategory = "";
//
//        if (maxCount == bullCount) {
//            Choice result = choiceRepository.findByName_choice("bull");
//            resultCategory = result.getName_choice();
//            resultId = choiceRepository.getId_result(result.getId_choice());
//        } else if (maxCount == ratCount) {
//            Choice result = choiceRepository.findByName_choice("rat");
//            resultCategory = result.getName_choice();
//            resultId = choiceRepository.getId_result(result.getId_choice());
//        } else if (maxCount == bearCount) {
//            Choice result = choiceRepository.findByName_choice("bear");
//            resultCategory = result.getName_choice();
//            resultId = choiceRepository.getId_result(result.getId_choice());
//        } else if (maxCount == eagleCount) {
//            Choice result = choiceRepository.findByName_choice("eagle");
//            resultCategory = result.getName_choice();
//            resultId = choiceRepository.getId_result(result.getId_choice());
//        }
//
//        return resultCategory;
//    }


//    public List<Choice> getAllChoices() {
//        return choiceRepository.findAll();
//    }

}



