package project_team_melody_is_error.la.leojaitherleuakRlai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result,Long> {
    Result getResultById(Long id);
}
