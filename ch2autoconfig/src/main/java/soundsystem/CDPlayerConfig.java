package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
public class CDPlayerConfig {


    //因为@Bean注解的缘故,sgtPeppers()在调用时总会被拦截,保持单例
    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }

//    @Bean
//    public CDPlayer cdPlayer(){
//        return new CDPlayer(sgtPeppers());
//    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }
}
