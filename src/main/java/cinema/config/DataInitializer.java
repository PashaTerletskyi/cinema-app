package cinema.config;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;

    public DataInitializer(UserService userService,
                           RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void inject() {
        Role admin = new Role();
        admin.setName(Role.RoleName.ADMIN);
        roleService.add(admin);

        Role user = new Role();
        user.setName(Role.RoleName.USER);
        roleService.add(user);

        User adminUser = new User();
        adminUser.setEmail("admin@gmail.com");
        adminUser.setPassword("admin");
        adminUser.setRoles(Set.of(admin));
        userService.add(adminUser);
    }
}
