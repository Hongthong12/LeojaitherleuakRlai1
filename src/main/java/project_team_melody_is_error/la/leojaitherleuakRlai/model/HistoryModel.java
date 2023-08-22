package project_team_melody_is_error.la.leojaitherleuakRlai.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class HistoryModel {
    private Long id;
    private LocalDateTime dateTime;
    private ArrayList<Integer> likechoices;
    private ArrayList<Integer> dischoice;
    private String account;
    private String result;
    private Object disChoiceIds;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Integer> getlikechoices() {
        return likechoices;
    }

    public void setLikeChoices(List<Integer> likeChoices) {
        this.likechoices = (ArrayList<Integer>) likeChoices;
    }

    public List<Integer> getDisChoice() {
        return dischoice;
    }

    public void setDisChoice(List<Integer> disChoice) {
        this.dischoice = (ArrayList<Integer>) disChoice;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = LocalDateTime.parse(dateTime);
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getLikeChoices() {
        return this.getLikeChoices();
    }

    public void setLikechoices(ArrayList<Integer> savedLikeList) {
    }

    public void setDischoices(ArrayList<Integer> savedDislikeList) {
    }



    public String getAccountId() {
        return account;
    }

    public String getResultId() {
        return result;
    }

    public Integer getLikeChoiceIds() {
        return getLikeChoices();
    }


    public Object getDisChoiceIds() {
        return disChoiceIds;
    }

    public void setDisChoiceIds(Object disChoiceIds) {
        this.disChoiceIds = disChoiceIds;
    }
}
