package denamed.TestWMS;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TestWmsApplication {
	public static void main(String[] args) {
		/* currently used database, also don't forget to modify application.properties */
		String dbname = ".\\test.db";
		/* check if database exist then continue else create new database file */
		if(!DbCheckerAndCreator.dbExist(dbname)){
			DbCheckerAndCreator.dbCreate(dbname);
		}

		SpringApplication.run(TestWmsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StockRepository stockRepository) {
		return args -> {
			Stock stock = new Stock(
					"somealletid1234567890", 10014030, "temp", 101, 1, 1, 1
			);
			stockRepository.save(stock);
		};
	}
}
