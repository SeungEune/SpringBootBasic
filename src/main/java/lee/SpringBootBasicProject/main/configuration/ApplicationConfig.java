package lee.SpringBootBasicProject.main.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    /**
     * DTO to VO, VO to DTO 변환을 위한 라이브러리 빈 등록
     * @return
     */
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
