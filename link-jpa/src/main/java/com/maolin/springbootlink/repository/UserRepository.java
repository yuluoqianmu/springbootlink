package com.maolin.springbootlink.repository;

import com.maolin.springbootlink.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shaomaolin on 2018/11/6.
 */
public interface UserRepository extends JpaRepository<User, Long> {


}
