package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Addresstoid implements Serializable {
    private Integer proviceid;

    private Integer quid;

    private String provicename;

    private String cityname;

    private String cityid;

    private String quname;

    private static final long serialVersionUID = 1L;

    public Integer getProviceid() {
        return proviceid;
    }

    public void setProviceid(Integer proviceid) {
        this.proviceid = proviceid;
    }

    public Integer getQuid() {
        return quid;
    }

    public void setQuid(Integer quid) {
        this.quid = quid;
    }

    public String getProvicename() {
        return provicename;
    }

    public void setProvicename(String provicename) {
        this.provicename = provicename;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getQuname() {
        return quname;
    }

    public void setQuname(String quname) {
        this.quname = quname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", proviceid=").append(proviceid);
        sb.append(", quid=").append(quid);
        sb.append(", provicename=").append(provicename);
        sb.append(", cityname=").append(cityname);
        sb.append(", cityid=").append(cityid);
        sb.append(", quname=").append(quname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}