package taskExecutionConverter.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SampleDataRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private SampleDataRepository sampleDataRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(dataSource, is(notNullValue()));
        assertThat(jdbcTemplate, is(notNullValue()));
        assertThat(entityManager, is(notNullValue()));
        assertThat(sampleDataRepository, is(notNullValue()));
    }
}
