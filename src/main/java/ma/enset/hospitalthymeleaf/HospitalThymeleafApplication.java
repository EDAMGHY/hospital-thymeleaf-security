package ma.enset.hospitalthymeleaf;

import ma.enset.hospitalthymeleaf.entities.Patient;
import ma.enset.hospitalthymeleaf.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HospitalThymeleafApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HospitalThymeleafApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        patientRepository.save(new Patient(null, "Mohammed", new Date(), false, 123));
//        patientRepository.save(new Patient(null, "Yassine", new Date(), true, 765));
//        patientRepository.save(new Patient(null, "Hamza", new Date(), false, 980));
    }
}
