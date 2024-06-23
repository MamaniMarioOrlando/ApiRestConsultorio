package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.Entity.MedicoEntity;
import med.voll.api.dto.MedicoDto;
import med.voll.api.dto.MedicoListDto;
import med.voll.api.repository.IMedicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    IMedicoRepository medicoRepository;
    @PostMapping
    public void registrarMedico(@RequestBody @Valid MedicoDto medicoDto){
        medicoRepository.save(new MedicoEntity(medicoDto));
    }
    @GetMapping
    public Page<MedicoListDto> getMedicos(@PageableDefault(size = 3, sort = "nombre") Pageable paginacion){
        return medicoRepository.findAll(paginacion).map(MedicoListDto::new);
    }
}
