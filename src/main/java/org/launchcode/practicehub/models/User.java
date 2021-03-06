package org.launchcode.practicehub.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity {

    @NotBlank(message = "Username is required")
    @Size(min = 3, message = "Username must be a minimum of 3 characters")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 4, message = "Password must be a minimum of 4 characters")
    private String pwHash;

    @NotBlank(message = "Skater name is required")
    private String skaterName;

//    private double currentMonthCredits = 0.0;

    @OneToMany(mappedBy = "user")
    private List<Practice> practices = new ArrayList<>();

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String username, String password, String skaterName) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.skaterName = skaterName;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public String getUsername() {
        return username;
    }

    public String getSkaterName() {

        return skaterName;
    }

    public void setSkaterName(String skaterName) {
        this.skaterName = skaterName;
    }

    public List<Practice> getPractices() {
        return practices;
    }

    public double setCurrentMonthTotal() {
        double total = 0;
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();

        for (Practice practice : this.getPractices()) {
            if (practice.getDate().getMonth() == currentMonth) {
                total += practice.getNumCredits();
            }
        }
        return total;
    }

    //
//    public double getCurrentMonthCredits() {
//        return currentMonthCredits;
//    }
//
//    public void setCurrentMonthCredits(double currentMonthCredits) {
//        this.currentMonthCredits = currentMonthCredits;
//    }

    //    public Player getPlayer() {
//        return player;
//    }
//
//    public void setPlayer(Player player) {
//        this.player = player;
//    }
}
