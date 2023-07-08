package ar.edu.unju.fi.TPFINALPV.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFINALPV.entity.User;
import ar.edu.unju.fi.TPFINALPV.repository.IUserRepository;
import ar.edu.unju.fi.TPFINALPV.service.IUserService;

@Service
public class UserService implements IUserService {
    
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getAllUsuarios() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void findUserByName(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUserByName'");
    }
    
}
