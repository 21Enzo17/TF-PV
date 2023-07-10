package ar.edu.unju.fi.TPFINALPV.service;

import java.util.List;

import ar.edu.unju.fi.TPFINALPV.entity.User;

public interface IUserService {
    public List<User> getAllUsuarios();

    public void addUser(User user);

    public User findByUser(Long id);
    public User getSesion();
    public void setSesion(User user);
    public List<User> getUsuarios();
}
