package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

	// To avoid 404s when using Angular HTML 5 routing
	@Bean
	ErrorViewResolver supportPathBasedLocationStrategyWithoutHashes() {
		return new ErrorViewResolver() {
			@Override
			public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
				return status == HttpStatus.NOT_FOUND
						? new ModelAndView("index.html", Collections.<String, Object>emptyMap(), HttpStatus.OK)
						: null;
			}
		};
	}


	/*@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				repo.save(new Ingredient("FLTO", "Flour Tortilla", WRAP));
				repo.save(new Ingredient("COTO", "Corn Tortilla", WRAP));
				repo.save(new Ingredient("GRBF", "Ground Beef", PROTEIN));
				repo.save(new Ingredient("CARN", "Carnitas", PROTEIN));
				repo.save(new Ingredient("TMTO", "Diced Tomatoes", VEGGIES));
				repo.save(new Ingredient("LETC", "Lettuce", VEGGIES));
				repo.save(new Ingredient("CHED", "Cheddar", CHEESE));
				repo.save(new Ingredient("JACK", "Monterrey Jack", CHEESE));
				repo.save(new Ingredient("SLSA", "Salsa", SAUCE));
				repo.save(new Ingredient("SRCR", "Sour Cream", SAUCE));
			}
		};
	}*/

}
