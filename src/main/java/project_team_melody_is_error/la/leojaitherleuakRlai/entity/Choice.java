package project_team_melody_is_error.la.leojaitherleuakRlai.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "choice")
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_choice")
    private Long id;


    @Column(name = "choice_eng")
    private String choiceEng;

    @Column(name = "choice_thai")
    private String choiceThai;

    @Column(name = "name_choice")
    private String nameChoice;

    @Column(name = "name_eng")
    private String nameEng;

    @ManyToOne
    @JoinColumn(name = "id_result")
    @JsonIgnore
    private Result result;

    @ManyToOne
    @JoinColumn(name = "id_history")
    private History history;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChoiceEng() {
        return choiceEng;
    }

    public void setChoiceEng(String choiceEng) {
        this.choiceEng = choiceEng;
    }

    public String getChoiceThai() {
        return choiceThai;
    }

    public void setChoiceThai(String choiceThai) {
        this.choiceThai = choiceThai;
    }

    public String getNameChoice() {
        return nameChoice;
    }

    public void setNameChoice(String nameChoice) {
        this.nameChoice = nameChoice;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public Integer getResultId() {
        return getResultId();
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
