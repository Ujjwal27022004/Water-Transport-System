package Team.Gamma.Water_Transport_System.Dto;

import java.util.Date;

public class QueryDTO {

    private String queryDetails;

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


