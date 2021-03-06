package com.demo.cinemamicroservice.cinemaservice.controllers.dto;

public class CinemaSeatDTO {

    public Long roomId;
    public Integer rowNum;
    public Integer colNum;
    public String mark;

    protected CinemaSeatDTO() {
    }

    public CinemaSeatDTO(Long roomId, Integer rowNum, Integer colNum, String mark) {
        this.roomId = roomId;
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.mark = mark;
    }
}
