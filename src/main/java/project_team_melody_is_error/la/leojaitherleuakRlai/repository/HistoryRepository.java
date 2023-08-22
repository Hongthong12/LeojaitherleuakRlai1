package project_team_melody_is_error.la.leojaitherleuakRlai.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Account;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Choice;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.History;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Result;
import project_team_melody_is_error.la.leojaitherleuakRlai.model.HistoryModel;

import java.util.List;


@Repository
public interface HistoryRepository extends JpaRepository<History,Long> {


    List<History> findByAccount(Account account);

    List<History> findByResult(Result result);


}
