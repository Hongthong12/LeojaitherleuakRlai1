package project_team_melody_is_error.la.leojaitherleuakRlai.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
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


    @OneToMany
    @JoinTable(
            name = "history_like_choice",
            joinColumns = @JoinColumn(name = "history_id"),
            inverseJoinColumns = @JoinColumn(name = "choice_id")
    )
    private List<Choice> likeChoices = new ArrayList<>();

    @OneToMany
    @JoinTable(
            name = "history_dis_choice",
            joinColumns = @JoinColumn(name = "history_id"),
            inverseJoinColumns = @JoinColumn(name = "choice_id")
    )
    private List<Choice> disChoices = new ArrayList<>();


    private boolean isDeleted; // เพิ่ม field นี้เพื่อบอกว่าประวัติการใช้งานนี้ถูกลบหรือไม่



    public History(LocalDateTime dateTime, String accountId, String resultId, Integer likeChoiceIds, Object disChoiceIds) {
        this.dateTime = dateTime;
        this.account = account;
        this.result = result;
        this.likeChoices = new ArrayList<>();
        this.disChoices = new ArrayList<>();
    }


    public void setLikeChoicesList(Set<Choice> likeChoicesList) {
    }

    public void setDisChoicesList(Set<Choice> disChoicesList) {
    }


    public void setAccount(Account account) {
        this.account = account;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public History() {
    }


    public History(LocalDateTime dateTime, Account accountId, Result resultId, List<Long> likeChoiceIds, List<Long> disChoiceIds) {
        this.dateTime = dateTime;
        this.account = account;
        this.result = result;
        this.likeChoices = new ArrayList<>();
        this.disChoices = new ArrayList<>();
    }

}
