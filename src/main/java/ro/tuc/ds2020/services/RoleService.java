package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.repositories.RoleRepository;
import ro.tuc.ds2020.repositories.UserRepository;

@Service
public class RoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

}
