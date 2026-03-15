package pl.kurs.java.model.dto;

import pl.kurs.java.model.Company;

public record CompanyDto(int id, String name, String city, long employeesSize) {
    public static CompanyDto fromEntity(Company company) {
        return new CompanyDto(company.getId(),
                company.getName(),
                company.getCity(),
                company.getEmployeesSize());
    }

    // dwie tabele
    // paginacja z 10 na stronie
    // dane z jednej tabeli 10 i dane z drugiej 10
    // ladcznie bylo 20 wynikow
    // view miala dane z obu tabel
    // dane byly tylko z jednej tabeli wiec pokazywalo sie 10 rekordow

}
