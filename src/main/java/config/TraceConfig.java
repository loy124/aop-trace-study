package config;

import config.trace.LocalLogTraceAspect;
import config.trace.ProdLogTraceAspect;
import config.trace.ThreadLocalLogTrace;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TraceConfig {


    @Bean
    @Profile("default")
    public LocalLogTraceAspect localLogTraceAspect(){
        return new LocalLogTraceAspect(new ThreadLocalLogTrace());
    }


    @Bean
    @Profile("prod")
    public ProdLogTraceAspect prodLogTraceAspect(){
        return new ProdLogTraceAspect( new ThreadLocalLogTrace());
    }




}
