package ar.edu.unju.fi.TPFINALPV.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFINALPV.entity.User;
import ar.edu.unju.fi.TPFINALPV.repository.IUserRepository;
import ar.edu.unju.fi.TPFINALPV.service.IUserService;

@Service
public class UserServiceImp implements IUserService {
    
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    User session;

    /**
     * Metodo que retorna la lista de usuarios
     */
    @Override
    public List<User> getAllUsuarios() {
        return (List<User>) userRepository.findAll();
    }
    /**
     * Metodo que agrega un usuario
     */
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    /**
     * Metodo que permite encontrar un usuario por ID
     */
    @Override
    public User findByUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Metodo que obtiene la sesion de un usuario
     * @return
     */
    @Override
    public User getSesion(){
        return session;
    }

    /**
     * Metodo que setea la sesion de un usuario
     * @param user
     */
    @Override
    public void setSesion(User user){
        this.session = user;
    }

    /**
     * Metodo que retorna la lista de usuarios
     */
    public List<User> getUsuarios(){
        return (List<User>) userRepository.findAll();
    }
}
