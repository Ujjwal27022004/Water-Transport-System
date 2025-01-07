package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.QueryDTO;
import Team.Gamma.Water_Transport_System.Entity.Query;
import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Repository.QueryRepository;
import Team.Gamma.Water_Transport_System.Repository.UserRepository;
import Team.Gamma.Water_Transport_System.Service.QueryService;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class QueryImpl implements QueryService {
    @Autowired
    private QueryRepository queryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginMessage askQuery(Long userid, QueryDTO queryDTO) {
        try {
            User user = userRepository.findById(userid)
                    .orElseThrow(() -> new RuntimeException("User not found with ID: " + userid));

            Query query = new Query();
            query.setUser(user);
            query.setQueryDetails(queryDTO.getQueryDetails());
            query.setStatus("Pending");
            query.setCreatedDate(new Date());

            queryRepository.save(query);

            return new LoginMessage("Query successfully Submitted!", true);
        } catch (RuntimeException e) {
            return new LoginMessage(e.getMessage(), false);
        } catch (Exception e) {
            return new LoginMessage("Error while submitting the query: " + e.getMessage(), false);
        }
    }

    @Override
    public LoginMessage resolveQuery(Long queryId, String resolutionDetails, String status) {

        try {
            Query query = queryRepository.findById(queryId)
                    .orElseThrow(() -> new RuntimeException("Query not found with ID: " + queryId));

        query.setQueryResolution(resolutionDetails);
        query.setResolvedDate(new Date());
        query.setStatus(status);

        queryRepository.save(query);
            return new LoginMessage("Query resolved successfully!", true);
        } catch (RuntimeException e) {
            return new LoginMessage(e.getMessage(), false);
        } catch (Exception e) {
            return new LoginMessage("Error while resolving the query: " + e.getMessage(), false);
        }
    }




}
