package com.al1x.jobhub.config;

import com.al1x.jobhub.model.entity.Role;
import com.al1x.jobhub.model.enums.ERole;
import com.al1x.jobhub.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderConfig implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role(1, ERole.USER));
            roleRepository.save(new Role(2, ERole.COMPANY));
            roleRepository.save(new Role(3, ERole.ADMIN));
        }
    }
}