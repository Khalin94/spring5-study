package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Config1.class, Config2.class})
public class ConfigImport {

}
