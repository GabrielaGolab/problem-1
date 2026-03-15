package pl.kurs.java.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kurs.java.model.Company;
import pl.kurs.java.model.Employee;
import pl.kurs.java.model.dto.CompanyDto;
import pl.kurs.java.repository.CompanyRepository;
import pl.kurs.java.repository.EmployeeRepository;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;

    @PostConstruct
    public void initialTestData() {
        Company openAi = companyRepository.saveAndFlush(
                Company.builder()
                        .domain("IT")
                        .city("Los Angeles")
                        .name("OpenAI")
                        .build()
        );
        Company spaceX = companyRepository.saveAndFlush(
                Company.builder()
                        .domain("Space-Explorations")
                        .city("Los Angeles")
                        .name("SpaceX")
                        .build()
        );
        Company amazon = companyRepository.saveAndFlush(
                Company.builder()
                        .domain("IT")
                        .city("Los Angeles")
                        .name("Amazon")
                        .build()
        );
        Company bmw = companyRepository.saveAndFlush(
                Company.builder()
                        .domain("automotive")
                        .city("Munich")
                        .name("BMW")
                        .build()
        );
        employeeRepository.saveAllAndFlush(Arrays.asList(
                Employee.builder()
                        .company(openAi).name("Jan").surname("Kowalski").age(30)
                        .build(),
                Employee.builder()
                        .company(openAi).name("Andrzej").surname("Kowalski").age(30)
                        .build(),
                Employee.builder()
                        .company(openAi).name("Sławek").surname("Kowalski").age(30)
                        .build(),
                Employee.builder()
                        .company(spaceX).name("Waldemar").surname("Kowalski").age(30)
                        .build(),
                Employee.builder()
                        .company(spaceX).name("Adam").surname("Kowalski").age(30)
                        .build(),
                Employee.builder()
                        .company(spaceX).name("Filip").surname("Kowalski").age(30)
                        .build(),
                Employee.builder()
                        .company(spaceX).name("Arek").surname("Kowalski").age(30)
                        .build(),
                Employee.builder()
                        .company(amazon).name("Darek").surname("Kowalski").age(30)
                        .build(),
                Employee.builder()
                        .company(amazon).name("Marek").surname("Kowalski").age(30)
                        .build(),
                Employee.builder()
                        .company(bmw).name("Franek").surname("Kowalski").age(30)
                        .build(),
                Employee.builder()
                        .company(bmw).name("Zenek").surname("Kowalski").age(30)
                        .build()
        ));

    }

    @Transactional(readOnly = true)
    public Page<CompanyDto> pageAll(Pageable pageable) {
        return companyRepository.findAllWithEmployees(pageable);
    }
}
