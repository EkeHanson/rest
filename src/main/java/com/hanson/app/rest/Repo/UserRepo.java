package com.hanson.app.rest.Repo;

import com.hanson.app.rest.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {


}
