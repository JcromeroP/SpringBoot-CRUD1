package com.api.crud.repositories;

import com.api.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Se pueden hacer consultas(query) a una base de datos
public interface IUserRepository extends JpaRepository<UserModel, Long> {
}
