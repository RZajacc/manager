package com.rafalzajac.manager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Position {

    private String position;

    @Override
    public String toString() {
        return position;
    }
}
