package com.ithiema.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class Job {
    private String number;
    private String jobName;
    private Compony compony;
    private String city;
    private Date updateDate;
    private String salary;
    private Integer distance;
    private Edu eduLevel;
    private List<JobType> jobType;
    private Double feedbackRation;
    private WorkingExp workingExp;
    private String industry;
    private String emplType;
    private String applyType;
    private Boolean saleType;
    private String positionURL;
    private String companyLogo;
    private List<String> tags;
    private Integer expandCount;
    private String score;
    private String vipLevel;
    private PositionLabel positionLabel;
    private List<String> welfare;
    private String businessArea;
    private Boolean futureJob;
    private String futureJobUrl;
    private Integer tagIntHighend ;
    private Integer rootOrgId ;
    private Integer  staffId;
    private Boolean selected;
    private Boolean applied;
    private Boolean collected;
    private Boolean isShow;
    private String timeState;
    private String rate;

}
