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
        User user = userRepository.findById(userid)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Query query = new Query();
        query.setUser(user);
        query.setQueryDetails(queryDTO.getQueryDetails());
        query.setStatus("Pending");
        query.setCreatedDate(new Date());

        user.getQueries().add(query);

        queryRepository.save(query);

        return new LoginMessage( "Query successfully Submitted!", true);

    }
}
