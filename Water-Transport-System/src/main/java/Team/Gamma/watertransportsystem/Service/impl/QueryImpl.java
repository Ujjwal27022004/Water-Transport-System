package Team.Gamma.watertransportsystem.Service.impl;

import Team.Gamma.watertransportsystem.Dto.QueryDTO;
import Team.Gamma.watertransportsystem.Entity.Query;
import Team.Gamma.watertransportsystem.Entity.User;
import Team.Gamma.watertransportsystem.Repository.QueryRepository;
import Team.Gamma.watertransportsystem.Repository.UserRepository;
import Team.Gamma.watertransportsystem.Service.QueryService;
import Team.Gamma.watertransportsystem.payload.response.LoginMessage;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class QueryImpl implements QueryService {

    private QueryRepository queryRepository;
    private UserRepository userRepository;

    public QueryImpl(QueryRepository queryRepository, UserRepository userRepository) {
        this.queryRepository = queryRepository;
        this.userRepository = userRepository;
    }




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
