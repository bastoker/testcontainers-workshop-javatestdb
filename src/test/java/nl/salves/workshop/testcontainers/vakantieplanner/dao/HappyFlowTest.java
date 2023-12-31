package nl.salves.workshop.testcontainers.vakantieplanner.dao;

import nl.salves.workshop.testcontainers.vakantieplanner.model.Holiday;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JooqTest
@ComponentScan(basePackages = {"nl.salves.workshop.testcontainers.vakantieplanner.dao"})
public class HappyFlowTest {

    private static PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:15");

    @Autowired
    private VakantieRepository repository;

    @DynamicPropertySource
    static void configureContext(DynamicPropertyRegistry registry) {
        postgres.start();
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Test
    public void canQueryDatabase() {
        int idOfPete = repository.getIdForUsername("pete");
        assertThat(idOfPete).isGreaterThan(0);
    }

    @Test
    public void canAddAndRetrieveHoliday() {
        Holiday persistedHoliday = repository.addHoliday("pete", new Holiday(
                -1,
                "Zomervakantie",
                LocalDate.of(2023, 8, 6),
                LocalDate.of(2023, 8, 25)));
        assertThat(persistedHoliday.id()).isGreaterThan(0);

        List<Holiday> holidaysOfPete = repository.retrieveHolidaysForMemberWithName("pete");
        assertThat(holidaysOfPete).hasSize(1);
        assertThat(holidaysOfPete.get(0).description()).isEqualTo("Zomervakantie");
    }

    @Test
    public void whenHolidayOverlapsItIsDetected() {
        Holiday persistedHoliday = repository.addHoliday("john", new Holiday(
                -1,
                "Zomervakantie",
                LocalDate.of(2020, 8, 6),
                LocalDate.of(2020, 8, 25)));

        boolean resultOverlapping = repository.checkIfHolidayIsPossible(
                LocalDate.of(2020, 7, 7),
                LocalDate.of(2020, 8, 7));

        assertThat(resultOverlapping).isEqualTo(false);

        boolean resultNotOverlapping = repository.checkIfHolidayIsPossible(
                LocalDate.of(2023, 7, 7),
                LocalDate.of(2023, 8, 7));

        assertThat(resultNotOverlapping).isEqualTo(true);

        boolean resultNotOverlappingEdgeCase = repository.checkIfHolidayIsPossible(
                LocalDate.of(2020, 8, 5),
                LocalDate.of(2020, 8, 5));

        assertThat(resultNotOverlappingEdgeCase).isEqualTo(true);
    }


}
