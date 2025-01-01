package Team.Gamma.Water_Transport_System.Dto;

import Team.Gamma.Water_Transport_System.Entity.User;

import java.util.Date;

public class QueryDTO {

    private String queryDetails;
    private Long queryid;
    private User user;

    public Long getQueryid() {
        return queryid;
    }

    public void setQueryid(Long queryid) {
        this.queryid = queryid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getQueryResolution() {
        return queryResolution;
    }

    public void setQueryResolution(String queryResolution) {
        this.queryResolution = queryResolution;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Date resolvedDate) {
        this.resolvedDate = resolvedDate;
    }

    private String queryResolution;
    private String status;
    private Date createdDate;
    private Date resolvedDate;


    public QueryDTO() {
    }




    public QueryDTO(String queryDetails) {
        this.queryDetails = queryDetails;
    }


    public String getQueryDetails() {
        return queryDetails;
    }

    public void setQueryDetails(String queryDetails) {
        this.queryDetails = queryDetails;
    }

}


