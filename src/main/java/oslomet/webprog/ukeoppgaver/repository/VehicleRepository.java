package oslomet.webprog.ukeoppgaver.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import oslomet.webprog.ukeoppgaver.model.Car;
import oslomet.webprog.ukeoppgaver.model.Registration;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {

    @Autowired
    private JdbcTemplate db;

    public void addRegistrations(Registration registration) {
        try {
            db.update("insert into Registration(ssn, name, address, characteristics, brand, type)" +
                            "values(?,?,?,?,?,?)",
                    registration.getSsn(), registration.getName(), registration.getAddress(),
                    registration.getCharacteristics(), registration.getBrand(), registration.getType()
            );
        } catch (Exception e) {
            System.out.println("Noe gikk galt med db update i addregistrations");
        }


    }

    public List<Registration> getRegistrations() {
        try {
            return db.query("select * from Registration",
                    new BeanPropertyRowMapper<>(Registration.class));
        } catch (Exception e) {
            System.out.println("Noe gikk galt med db.query i getRegistrations");
            return null;
        }
    }

    public List<Car> getCars() {
        try {
            return db.query("select * from Car",
                    new BeanPropertyRowMapper<>(Car.class));
        } catch (Exception e) {
            System.out.println("Noe gikk galt med db.query i getRegistrations");
            return null;
        }
    }

    public void deleteVehicles() {
        try {
            db.update("delete from Registration");
        } catch (Exception e) {
            System.out.println("Noe gikk galt med deleteVehicles() i repo");
        }
    }

    public void deleteSingleRegistration(int id) {
        try {
            db.update("delete from Registration where id = ?", id);
        } catch (Exception e) {
            System.out.println("Noe gikk galt med delete SingleRegistration i repo");
        }
    }
}
