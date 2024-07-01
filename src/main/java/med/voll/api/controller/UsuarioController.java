package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    @Autowired
    AuthenticationManager authenticationManager;
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid UsuarioDto usuarioDto){
        Authentication token = new UsernamePasswordAuthenticationToken(usuarioDto.login(), usuarioDto.clave());
        authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
