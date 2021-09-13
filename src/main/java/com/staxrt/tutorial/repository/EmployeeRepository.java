package com.staxrt.tutorial.repository;

import com.staxrt.tutorial.model.Employee;
import com.staxrt.tutorial.model.Output1Int;
import com.staxrt.tutorial.model.Output2Int;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT e.department as deptname, count(*) as count  FROM Employee e WHERE e.gender = :gender group by e.department ",
            nativeQuery = true)
    List<Output2Int> findCountByGender(@Param("gender") String gender);


   // SELECT e.gender as gender, concat(min(e.age),"-",max(e.age)) as minmax  FROM Employee e WHERE e.department = "CSE" group by e.gender
    @Query(value = "SELECT e.gender as gender, concat(min(e.age),\"-\",max(e.age)) as minmax  FROM Employee e WHERE e.department = :deptname group by e.gender ",
            nativeQuery = true)
    List<Output1Int> findMinMaxByDept(@Param("deptname") String deptname);
}
