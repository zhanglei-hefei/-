package com.ithiema.domain;

import lombok.Data;

import java.util.List;
@lombok.Data
public class Fuck {
    private Integer chatTotal;
    private Integer chatWindowState;
    private Integer count;
    private Boolean informationStream;
    private Boolean jobLabel;
    private String method;
    private Integer typeSearch;
    private List<Job> results;
    private String taskId;
    private Integer numFound;
    private Integer numTotal;
}
