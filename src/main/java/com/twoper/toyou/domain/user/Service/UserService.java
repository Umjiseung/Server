//package com.example.twoper.jwt.Service;
//
//import com.example.twoper.jwt.model.User;
//import com.example.twoper.jwt.model.dto.RegisterDto;
//import com.example.twoper.jwt.repoditory.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//
//    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public User register(RegisterDto registerDto) {
//        User user = new User();
//        user.setName(registerDto.getName());
//        user.setPassword(bCryptPasswordEncoder.encode(registerDto.getPassword()));
//        user.setUsername(registerDto.getUsername());
//        user.setRoles("ROLE_USER");
//        return userRepository.save(user);
//    }
//
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    public User findUser(int id) {
//        return userRepository.findById(id).orElseThrow(()-> {
//            return new IllegalArgumentException("User ID를 찾을 수 없습니다.");
//        });
//    }
//}

package com.twoper.toyou.domain.user.Service;

import com.twoper.toyou.domain.user.model.User;
import com.twoper.toyou.domain.user.model.dto.RegisterDto;
import com.twoper.toyou.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User register(RegisterDto registerDto) {
        User user = new User();
        user.setName(registerDto.getName());
        user.setPassword(bCryptPasswordEncoder.encode(registerDto.getPassword()));
        user.setUsername(registerDto.getUsername());
        user.setRoles("ROLE_USER");
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUser(int id) {
        return userRepository.findById(id).orElseThrow(()-> {
            return new IllegalArgumentException("User ID를 찾을 수 없습니다.");
        });
    }
}