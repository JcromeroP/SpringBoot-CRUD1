package com.api.crud.services;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired//Inyectar dependencias
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }

    public UserModel updateById(UserModel request, Long id){
        UserModel user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No user found with ID: " + id));

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());

        return userRepository.save(user);

    }

    public String deleteUserById(Long id){
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el usuario con el ID: " + id));

        userRepository.delete(user);

        return "El producto con el ID: " + id + " fue eliminado con éxtio";


    }
}
