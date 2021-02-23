package rajan.wrkspot.demo.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rajan.wrkspot.demo.myapp.models.Address;
import rajan.wrkspot.demo.myapp.models.Corporation;
import rajan.wrkspot.demo.myapp.models.Hotel;
import rajan.wrkspot.demo.myapp.models.Lead;
import rajan.wrkspot.demo.myapp.repository.CorporationRepository;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

@SpringBootApplication
public class MyappApplication  implements CommandLineRunner{


	@Autowired
	private CorporationRepository corporationRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



		// One Corporation
		Corporation corp1 = new Corporation();
		corp1.setCorpName("The ABC");
		corp1.setAddress(new Address("Jersry City", "New Jersey", "USA", "07307"));
		Hotel hotel1 = new Hotel("MyHotel1",new Address("New York City", "New York","USA","10040"));
		Hotel hotel2 = new Hotel("MyHotel2",new Address("Harrisburg", "Pennsylvania","USA","05000"));
		corp1.setHotels(Arrays.asList(hotel1,hotel2));
		corp1.setLead(new Lead("Rajan", "Patel"));


		// Two Corporation
		Corporation corp2 = new Corporation();
		corp2.setCorpName("The CDE");
		corp2.setAddress(new Address("New York City", "New York", "USA", "01001"));
		Hotel hotel3 = new Hotel("MyHotel3",new Address("New York City", "New York","USA","10040"));
		Hotel hotel4 = new Hotel("MyHotel4",new Address("Boston", "Massachusetts","USA","05000"));
		corp2.setHotels(Arrays.asList(hotel3,hotel4));
		corp2.setLead(new Lead("Keith","Eric"));

		corporationRepository.save(corp1);
		corporationRepository.save(corp2);






	}


}
