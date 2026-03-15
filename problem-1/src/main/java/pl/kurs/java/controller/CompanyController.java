package pl.kurs.java.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kurs.java.model.dto.CompanyDto;
import pl.kurs.java.service.CompanyService;

@RestController
@RequestMapping("/api/v1/companies") //-- zamiast request było rest
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService; // - nie było final

    @GetMapping
    public Page<CompanyDto> pageAll(@PageableDefault Pageable pageable) {
        return companyService.pageAll(pageable);
    }
}
