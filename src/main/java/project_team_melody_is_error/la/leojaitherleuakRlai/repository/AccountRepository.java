package project_team_melody_is_error.la.leojaitherleuakRlai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {


    Account findByEmail(String email);
}
