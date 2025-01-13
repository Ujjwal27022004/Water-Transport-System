package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.QueryDTO;
import Team.Gamma.Water_Transport_System.Entity.Query;
import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Repository.QueryRepository;
import Team.Gamma.Water_Transport_System.Repository.UserRepository;
import Team.Gamma.Water_Transport_System.Service.QueryService;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueryImpl implements QueryService {

    private QueryRepository queryRepository;
    private UserRepository userRepository;

    public QueryImpl(QueryRepository queryRepository, UserRepository userRepository) {
        this.queryRepository = queryRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<QueryDTO> getAllQueries() {
        return queryRepository.findAll()
                .stream()
                .map(query -> {
                    QueryDTO dto = new QueryDTO();
                    dto.setQueryid(query.getqueryid()); // Map Query ID
                    dto.setUser(query.getUser()); // Map User entity directly
                    dto.setQueryDetails(query.getQueryDetails());
                    dto.setStatus(query.getStatus());
                    dto.setCreatedDate(query.getCreatedDate());
                    dto.setResolvedDate(query.getResolvedDate());
                    dto.setQueryResolution(query.getQueryResolution());
                    return dto;
                })
                .collect(Collectors.toList());
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

            return new LoginMessage("Query successfully Submitted!", true, "user");
        } catch (RuntimeException e) {
            return new LoginMessage(e.getMessage(), false, "user");
        } catch (Exception e) {
            return new LoginMessage("Error while submitting the query: " + e.getMessage(), false, "user");
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
            return new LoginMessage("Query resolved successfully!", true, "user");
        } catch (RuntimeException e) {
            return new LoginMessage(e.getMessage(), false, "user");
        } catch (Exception e) {
            return new LoginMessage("Error while resolving the query: " + e.getMessage(), false, "user");
  }
}

}