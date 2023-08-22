package project_team_melody_is_error.la.leojaitherleuakRlai.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project_team_melody_is_error.la.leojaitherleuakRlai.entity.Choice;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice,Long> {


    @Query("SELECT c FROM Choice c WHERE c.id IN :ids")
    List<Choice> findAllById(@Param("ids") List<Long> ids);


    Optional<Choice> findById(long Id);

    Optional<Choice> findAllById(Long id);


//    List<Choice> findAllById(List<Long> likeChoiceIdsList);
}
