package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {
    @Bean
    public DataSource getDataSource () {
        return new JndiDataSourceLookup().getDataSource("jdbc/Database");
    }
}
