package zorrillo.reto2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zorrillo.reto2.model.User;
import zorrillo.reto2.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author LUIS GERMAN ORTEGA M.
 */
/**
     * Clase servicio de usuario
     */
@Service
public class UserService {

    /**
     * Autowired
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Servicio para traer todos los usuarios
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }

    /**
     * Servicio pra traer un usuario por su Id
     */
    public Optional<User> getUser(Integer id) {
        return userRepository.getUser(id);
    }

    /**
     * Servicio para comprobar si existe un mail
     */
    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    /**
     * Servicio para comprobar si existe una combinacion de mail y password,
     * devuelve un ususario si existe o devuelve un objeto null si no
     */
    public User autenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.autenticateUser(email, password);
        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }

    /**
     * Servicio para crear un nuevo usuario
     */
    public User create(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> e = userRepository.getUser(user.getId());
            if (e.isEmpty()) {
                if (existeEmail(user.getEmail()) == false) {
                    return userRepository.create(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
    }

    /**
     * Servicio para actualizar los datos de un usuario existente
     */
    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getBirthtDay() != null) {
                    userDb.get().setBirthtDay(user.getBirthtDay());
                }
                if (user.getMonthBirthtDay() != null) {
                    userDb.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    /**
     * Servicio para borrar un usuario, recibe id del ususario a borrar
     */
    public boolean delete(int userId) {
        Optional<User> usuario = userRepository.getUser(userId);
        if (usuario.isEmpty()) {
            return false;
        } else {
            userRepository.delete(usuario.get());
            return true;
        }
    }

}
