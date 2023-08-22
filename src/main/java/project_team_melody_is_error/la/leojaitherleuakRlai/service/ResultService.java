package project_team_melody_is_error.la.leojaitherleuakRlai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Result;
import project_team_melody_is_error.la.leojaitherleuakRlai.model.ResultModel;
import project_team_melody_is_error.la.leojaitherleuakRlai.repository.ResultRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public List<ResultModel> findAllResults() {
        return resultRepository.findAll().stream()
                .map(result -> {
                    ResultModel resultModel = new ResultModel();
                    resultModel.setId(result.getId());
                    resultModel.setPersonalityTh(result.getPersonalityTh());
                    resultModel.setPersonalityEng(result.getPersonalityEng());
                    resultModel.setCategory(result.getCategory());
                    resultModel.setCategoryEng(result.getCategoryEng());
                    return resultModel;
                }).collect(Collectors.toList());
    }

    public ResultModel findResultById(Long id) {
        Optional<Result> resultOptional = resultRepository.findById(id);
        if (resultOptional.isPresent()) {
            Result result = resultOptional.get();
            ResultModel resultModel = new ResultModel();
            resultModel.setId(result.getId());
            resultModel.setPersonalityTh(result.getPersonalityTh());
            resultModel.setPersonalityEng(result.getPersonalityEng());
            resultModel.setCategory(result.getCategory());
            resultModel.setCategoryEng(result.getCategoryEng());
            return resultModel;
        }
        return null;
    }



    public ResultModel createResult(ResultModel resultModel) {
        Result result = new Result();
        result.setPersonalityTh(resultModel.getPersonalityTh());
        result.setPersonalityEng(resultModel.getPersonalityEng());
        result.setCategory(resultModel.getCategory());
        result.setCategoryEng(resultModel.getCategoryEng());
        resultRepository.save(result);
        resultModel.setId(result.getId());
        return resultModel;
    }
}
