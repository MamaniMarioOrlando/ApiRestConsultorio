package med.voll.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import med.voll.api.Entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;
    public String generarToken(UsuarioEntity usuarioEntity){
        try{
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("vol med")
                    .withSubject(usuarioEntity.getLogin())
                    .withClaim("id",usuarioEntity.getId())
                    .withExpiresAt(generarFechaDeExpiracion())
                    .sign(algorithm);
        }catch (JWTCreationException e){
            throw new RuntimeException();
        }
    }
    public Instant generarFechaDeExpiracion(){
        return LocalDateTime.now()
                .plusMinutes(2)
                .toInstant(ZoneOffset.of("-05:00"));
    }
}
