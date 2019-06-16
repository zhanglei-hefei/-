package com.ithiema.domain;

import lombok.Data;

import java.util.List;
@Data
public class PositionLabel {
    private Boolean qualifications;
    private Boolean role;
    private Boolean chatWindow;
    private Integer refreshLevel ;
    private List<Skill> skillLabel;
}
