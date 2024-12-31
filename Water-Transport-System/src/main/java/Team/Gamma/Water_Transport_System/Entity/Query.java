package Team.Gamma.Water_Transport_System.Entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "query")
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "query_id", length = 45)
    private Long queryid;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Reference to the User entity (Foreign Key)

    @Column(name = "query_details", length = 500)
    private String queryDetails;

    @Column(name = "query_resolution", length = 500,  nullable = true)
    private String queryResolution;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "resolved_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date resolvedDate;

    public Query() {
    }

    public Query(Long queryid, Date resolvedDate, Date createdDate, String status, String queryResolution, String queryDetails, User user) {
        this.queryid = queryid;
        this.resolvedDate = resolvedDate;
        this.createdDate = createdDate;
        this.status = status;
        this.queryResolution = queryResolution;
        this.queryDetails = queryDetails;
        this.user = user;
    }

    // Getters and Setters
    public Long getqueryid() {
        return queryid;
    }

    public void setqueryid(Long queryid) {
        this.queryid = queryid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getQueryDetails() {
        return queryDetails;
    }

    public void setQueryDetails(String queryDetails) {
        this.queryDetails = queryDetails;
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
}

