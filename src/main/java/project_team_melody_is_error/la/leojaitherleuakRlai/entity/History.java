package project_team_melody_is_error.la.leojaitherleuakRlai.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_history")
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "id_account")
    private Account account;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_result")
    private Result result;


    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "history_like_choices",
            joinColumns = @JoinColumn(name = "history_id"),
            inverseJoinColumns = @JoinColumn(name = "choice_id"))
    private List<Choice> likeChoices;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "history_dis_choices",
            joinColumns = @JoinColumn(name = "history_id"),
            inverseJoinColumns = @JoinColumn(name = "choice_id"))
    private List<Choice> disChoices;





    public void setLikeChoicesList(Set<Choice> likeChoicesList) {
    }

    public void setDisChoicesList(Set<Choice> disChoicesList) {
    }

    public void setDisChoice(List<Integer> disChoice) {
    }

    public void setLikeChoice(List<Integer> likeChoice){

    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public History() {
    }


    private boolean isDeleted = false; // เพิ่ม field นี้เพื่อบอกว่าประวัติการใช้งานนี้ถูกลบหรือไม่

}
