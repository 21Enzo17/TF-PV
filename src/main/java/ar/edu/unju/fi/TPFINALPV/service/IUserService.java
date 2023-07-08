package ar.edu.unju.fi.TPFINALPV.service;

import java.util.List;

import ar.edu.unju.fi.TPFINALPV.entity.User;

public interface IUserService {
    public List<User> getAllUsuarios();

    public void addUser(User user);

    public void findUserByName(String nombre);
}
