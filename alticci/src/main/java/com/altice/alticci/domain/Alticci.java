package com.altice.alticci.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alticci implements Serializable {

    @Serial
    private static final long serialVersionUID = -6794216008744239361L;

    private Long key;
    private BigDecimal value;
}
