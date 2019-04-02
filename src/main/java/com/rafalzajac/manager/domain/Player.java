package com.rafalzajac.manager.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
@Getter @Setter
public class Player {


    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty(message = "You must enter your first name")
    private String first_name;
    @NotEmpty(message = "You must enter your last name")
    private String last_name;
    private String email;
    private String password;
    private String position;
    private int age;
    private int height;
    private int weight;
    private int spike_height;
    private int block_height;
    private String current_club;
    private String contract_expires;

    public Player() {}

    public Player(@NotEmpty(message = "You must enter your first name") String first_name, @NotEmpty(message = "You must enter your last name") String last_name, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    public Player(@NotEmpty(message = "You must enter your first name") String first_name, @NotEmpty(message = "You must enter your last name") String last_name, String position, int age, int height, int weight, int spike_height, int block_height, String current_club, String contract_expires) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.spike_height = spike_height;
        this.block_height = block_height;
        this.current_club = current_club;
        this.contract_expires = contract_expires;
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

