package com.rafalzajac.manager.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity class with both data required for registration and describing a player. Perhaps it should be two separate
 * classess mapped to each other but I decided to keep it this way at least for now.
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {


    //Data required for registration
    @NotNull
    @Size(min = 3, message = "You must enter your username and it should be at least 3 charaters long!")
    private String username;
    @NotEmpty(message = "You must enter your first name!")
    private String first_name;
    @NotEmpty(message = "You must enter your last name!")
    private String last_name;
    @NotEmpty(message = "You must enter email adress!")
    private String email;
    @NotEmpty(message = "You must enter password!")
    private String password;

    //All other data describing player
    @Id
    @GeneratedValue
    private Long id;
    private String position;
    private int age;
    private int height;
    private int weight;
    private int spike_height;
    private int block_height;
    @NotEmpty(message = "You must enter your current club!")
    private String current_club;
    @NotEmpty(message = "You must enter your contract expiration date!")
    private String contract_expires;


    /**
     * Constructor that is almost all args. I wanted id to be generated automatically but all args constructor from
     * lombok wants me to specify id anyway, so its almost the same but without id
     * @param username
     * @param first_name
     * @param last_name
     * @param email
     * @param password
     * @param position
     * @param age
     * @param height
     * @param weight
     * @param spike_height
     * @param block_height
     * @param current_club
     * @param contract_expires
     */
    public Player(@NotNull @Size(min = 3, message = "You must enter your username and it should be at least 3 charaters long!") String username, @NotEmpty(message = "You must enter your first name!") String first_name, @NotEmpty(message = "You must enter your last name!") String last_name, @NotEmpty(message = "You must enter email adress!") String email, @NotEmpty(message = "You must enter password!") String password, String position, int age, int height, int weight, int spike_height, int block_height, String current_club, String contract_expires) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.position = position;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.spike_height = spike_height;
        this.block_height = block_height;
        this.current_club = current_club;
        this.contract_expires = contract_expires;
    }


    /**
     * Method getting all player information from registration form, accepting password encoder. Returns new player
     * with hashed password provied by the user and saves it to database in registration controller.
     * @param passwordEncoder
     * @return
     */
    public Player toUser(PasswordEncoder passwordEncoder) {
        return new Player(
                username, first_name, last_name, email, passwordEncoder.encode(password), position, age, height, weight, spike_height, block_height, current_club, contract_expires) ;
    }


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", spike_height=" + spike_height +
                ", block_height=" + block_height +
                ", current_club='" + current_club + '\'' +
                ", contract_expires='" + contract_expires + '\'' +
                '}';
    }
}

