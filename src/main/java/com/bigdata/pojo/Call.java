package com.bigdata.pojo;

import java.io.Serializable;

public class Call implements Serializable {
    private Integer id;
    private Integer telid;
    private Integer dateid;
    private Integer sumcall;
    private Integer sumduration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTelid() {
        return telid;
    }

    public void setTelid(Integer telid) {
        this.telid = telid;
    }

    public Integer getDateid() {
        return dateid;
    }

    public void setDateid(Integer dateid) {
        this.dateid = dateid;
    }

    public Integer getSumcall() {
        return sumcall;
    }

    public void setSumcall(Integer sumcall) {
        this.sumcall = sumcall;
    }

    public Integer getSumduration() {
        return sumduration;
    }

    public void setSumduration(Integer sumduration) {
        this.sumduration = sumduration;
    }

    @Override
    public String toString() {
        return "Call{" +
                "id=" + id +
                ", telid=" + telid +
                ", dateid=" + dateid +
                ", sumcall=" + sumcall +
                ", sumduration=" + sumduration +
                '}';
    }
}
