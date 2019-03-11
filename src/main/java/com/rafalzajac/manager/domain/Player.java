package com.rafalzajac.manager.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
@Getter @Setter
@RequiredArgsConstructor
public class Player {

    //Pomysl nad dodaniem opcji czy ma managera, kto to jest i ew kontakt

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty(message = "You must enter your first name")
    private String first_name;
    @NotEmpty(message = "You must enter your last name")
    private String last_name;
    private String position;
    private int age;
    private int height;
    private int weight;
    private int spike_height;
    private int block_height;
    private String current_club;
    private String contract_expires;



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

