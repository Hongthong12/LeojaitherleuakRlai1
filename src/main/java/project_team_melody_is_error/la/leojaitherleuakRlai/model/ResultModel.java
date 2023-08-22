package project_team_melody_is_error.la.leojaitherleuakRlai.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ResultModel {
    private Long id;
    private String personalityTh;
    private String personalityEng;
    private String category;
    private String categoryEng;
}
