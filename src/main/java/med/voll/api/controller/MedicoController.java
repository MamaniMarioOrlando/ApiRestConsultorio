package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.Entity.MedicoEntity;
import med.voll.api.dto.MedicoDto;
import med.voll.api.repository.IMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    IMedicoRepository medicoRepository;
    @PostMapping
    public void registrarMedico(@RequestBody @Valid MedicoDto medicoDto){
        medicoRepository.save(new MedicoEntity(medicoDto));
    }
}
