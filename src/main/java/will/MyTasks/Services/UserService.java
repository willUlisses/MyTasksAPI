package will.MyTasks.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import will.MyTasks.DTOs.UserBodyDTO;
import will.MyTasks.Models.Users;
import will.MyTasks.Repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // métodos de endpoint GET
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public Users findByEmail(String email) {
        return userRepository.findByEmail(email); // apenas um só porque o email do usuário é único
    }

    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Users findById(Long id) {
        return Optional.of(userRepository.findById(id)).get().orElse(new Users("User not found", "...", "..."));
    }

    // metodo de endpoint POST

    public Users save(UserBodyDTO data) { // recebe um objeto que contém os dados mas que não é um usuário em sí e instancia um novo usuário

        if (userRepository.findByUsername(data.username()) == null) {
            throw new RuntimeException("Username already exists");
        }

        Users newUser = new Users(data.username(), data.password(), data.email());
        return userRepository.save(newUser);
    }

    // metodo de endpoint DELETE

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    // métodos de atualização

    @Transactional
    public Users putUser(Long id, UserBodyDTO data) { // atualizar um usuário por completo
        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setUsername(data.username());
        existingUser.setPassword(data.password());
        existingUser.setEmail(data.email());

        return userRepository.save(existingUser);
    }

}
