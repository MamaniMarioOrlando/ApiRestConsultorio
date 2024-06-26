package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.Entity.DireccionEntity;
import med.voll.api.Entity.MedicoEntity;
import med.voll.api.dto.*;
import med.voll.api.repository.IMedicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    IMedicoRepository medicoRepository;
    @PostMapping
    public ResponseEntity<DatosRespuestaMedicoDto> registrarMedico(@RequestBody @Valid MedicoDto medicoDto, UriComponentsBuilder uriComponentsBuilder){
        MedicoEntity medicoEntity = medicoRepository.save(new MedicoEntity(medicoDto));

        DatosRespuestaMedicoDto datosRespuestaMedicoDto = new DatosRespuestaMedicoDto(
                medicoEntity.getId(), medicoEntity.getNombre(),
                medicoEntity.getEmail(),  medicoEntity.getDocumento(),
                medicoEntity.getTelefono(), medicoEntity.getEstado(),
                new DireccionEntity(medicoEntity.getDireccion().getCiudad(),
                        medicoEntity.getDireccion().getCalle(),
                        medicoEntity.getDireccion().getNumero(),
                        medicoEntity.getDireccion().getDistrito(),
                        medicoEntity.getDireccion().getComplemento()));
        URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medicoEntity.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaMedicoDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaMedicoDto> getMedicoById(@PathVariable Long id){
        MedicoEntity medicoEntity = medicoRepository.getReferenceById(id);
        var datosMedicoDto = new DatosRespuestaMedicoDto(medicoEntity.getId(), medicoEntity.getNombre(),
                medicoEntity.getEmail(),  medicoEntity.getDocumento(),
                medicoEntity.getTelefono(), medicoEntity.getEstado(),
                new DireccionEntity(medicoEntity.getDireccion().getCiudad(),
                        medicoEntity.getDireccion().getCalle(),
                        medicoEntity.getDireccion().getNumero(),
                        medicoEntity.getDireccion().getDistrito(),
                        medicoEntity.getDireccion().getComplemento()));
        return ResponseEntity.ok(datosMedicoDto);
    }
    @GetMapping
    public ResponseEntity<Page<MedicoListDto>> getMedicos(@PageableDefault(size = 3, sort = "nombre") Pageable paginacion){
        //return medicoRepository.findAll(paginacion).map(MedicoListDto::new);
        return ResponseEntity.ok(medicoRepository.findAllByEstadoTrue(paginacion).map(MedicoListDto::new));
    }
    @PutMapping
    @Transactional
    public ResponseEntity actualizarMedico(@RequestBody @Valid ActualizarMedicoDto actualizarMedicoDto){
        MedicoEntity medicoEntity = medicoRepository.getReferenceById(actualizarMedicoDto.id());
        medicoEntity.actualizarDatosMedico(actualizarMedicoDto);
        return ResponseEntity.ok(new DatosRespuestaMedicoDto(
                medicoEntity.getId(), medicoEntity.getNombre(),
                medicoEntity.getEmail(),  medicoEntity.getDocumento(),
                medicoEntity.getTelefono(), medicoEntity.getEstado(),
                new DireccionEntity(medicoEntity.getDireccion().getCiudad(),
                        medicoEntity.getDireccion().getCalle(),
                        medicoEntity.getDireccion().getNumero(),
                        medicoEntity.getDireccion().getDistrito(),
                        medicoEntity.getDireccion().getComplemento())
                ));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable Long id){
        MedicoEntity medicoEntity = medicoRepository.getReferenceById(id);
        medicoEntity.estadoFalse();
        return ResponseEntity.noContent().build();
    }
    //public void eliminarMedico(@PathVariable Long id){
    //    MedicoEntity medicoEntity = medicoRepository.getReferenceById(id);
    //    medicoRepository.delete(medicoEntity);
    //}
}
