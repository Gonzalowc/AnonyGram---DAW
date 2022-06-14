package proyecto.daw.anonygram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class AnonyGramApplication.
 * 
 * @author Gonzalo Waack Carneado
 */
@SpringBootApplication
public class AnonyGramApplication {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(AnonyGramApplication.class, args);
    }
    // BEAN PARA HABILITAR i18n
    // @Bean
    // public MessageSource messageSource() {
    // ResourceBundleMessageSource messageSource = new
    // ResourceBundleMessageSource();
    // messageSource.setBasename("locale/messages");
    // return messageSource;
    // }
}
