package project_team_melody_is_error.la.leojaitherleuakRlai.model;

import lombok.Data;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Account;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Result;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class HistoryModel {
    private LocalDateTime dateTime;
    private Long accountId;
    private Long resultId;
    private List<Long> likeChoices;
    private List<Long> disChoices;
    private boolean isDeleted;
    private Account account;
    private Result result;

    public LocalDateTime getDateTime() {

        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getAccountId() {

        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }



    public void setLikeChoices(List<Long> likeChoices) {
        this.likeChoices = likeChoices;
    }

    public List<Long> getLikeChoices() {

        return likeChoices;
    }

    public List<Long> getDisChoices() {

        return disChoices;
    }

    public void setDisChoices(List<Long> disChoices) {
        this.disChoices = disChoices;
    }

    public boolean isDeleted() {

        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Account getAccount() {

        return account;
    }

    public Result getResult() {

        return result;
    }

//    public List<Integer> getDisChoice() {
//        return disChoice;
//    }
}
