package com.rafalzajac.manager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Simple class providing position as object for controller method
 */
@Data
@AllArgsConstructor
public class Position {

    private String position;

    @Override
    public String toString() {
        return position;
    }
}
