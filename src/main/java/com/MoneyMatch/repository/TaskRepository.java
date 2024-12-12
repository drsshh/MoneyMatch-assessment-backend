package com.MoneyMatch.repository;


import com.MoneyMatch.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t WHERE t.id LIKE :prefix%")
    List<Task> findByIdStartingWith(@Param("prefix") String prefix);

    @Query("SELECT t FROM Task t WHERE t.progress = 'R'")
    List<Task> findTasksRemoved();

    @Query("SELECT t FROM Task t WHERE t.progress != 'R'")
    List<Task> findTasksNotRemoved();

    @Query("SELECT t FROM Task t WHERE t.progress = 'F'")
    List<Task> findTasksProgressFinish();

    @Query("SELECT t FROM Task t WHERE t.progress = 'D'")
    List<Task> findTasksProgressNotDone();

}
