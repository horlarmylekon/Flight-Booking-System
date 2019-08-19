package com.aerotravel.flightticketbooking.core.setup;


import com.aerotravel.flightticketbooking.role_management.RoleRepository;
import com.aerotravel.flightticketbooking.user_management.model.Admin;
import com.aerotravel.flightticketbooking.user_management.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SetupConfiguration implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void run(String... args) throws Exception {

        logger.info("Setting up an Admin Admin");
        //check if the program should create a default
        //super admin user
        if(shouldCreateDefaultSuperAdmin()){
            //if not
            createDefaultSuperAdminRoleAndUser();
        }
    }

    private boolean shouldCreateDefaultSuperAdmin(){

        logger.info("Checking if super admin user should be created");
        // check if a user with username superadmin is present
        boolean superAdminExists = userRepository.existsByUsername("superadmin");
        if(!superAdminExists){
            logger.info("Super admin will be created");
            return true;
        }
        logger.info("Super admin already exists");
        return false;
    }

    @Transactional
    public void createDefaultSuperAdminRoleAndUser(){

        logger.info("Creating a default super admin role and user");

        try{
            //Admin user = userRepository.findUserByRoles("SUPER_ADMIN");

//            if(user == null){
//                logger.info("No super admin user found, will try to create one");
//
//            }

            Admin adminUser = new Admin();
            adminUser.setFirstname("super");
            adminUser.setLastname("admin");
            adminUser.setEmail("oyeknamiakandeworld@gmail.com");
            adminUser.setUsername("superadmin");
            //adminUser.setRoles();
            adminUser.setPassword(bCryptPasswordEncoder.encode("password"));

            userRepository.save(adminUser);
            logger.info("Super admin users created");
        }catch (Exception e){
            logger.error("Failed to create super admin", e);
        }
    }

}
