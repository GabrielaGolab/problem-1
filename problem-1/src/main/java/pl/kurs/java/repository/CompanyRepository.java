package pl.kurs.java.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.kurs.java.model.Company;
import pl.kurs.java.model.dto.CompanyDto;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query(value = "select new pl.kurs.java.model.dto.CompanyDto(c.id,c.name,c.city, (select count(e) from Employee e" +
            " where e.company.id = c.id)  as employeesSize) from Company c",
            countQuery = "select count(c) from Company c")
    Page<CompanyDto> findAllWithEmployees(Pageable pageable);
}
