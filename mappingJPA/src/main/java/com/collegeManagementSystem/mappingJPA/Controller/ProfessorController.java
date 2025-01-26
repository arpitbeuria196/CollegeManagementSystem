package com.collegeManagementSystem.mappingJPA.Controller;

import com.collegeManagementSystem.mappingJPA.DTO.ProffessorDTO;
import com.collegeManagementSystem.mappingJPA.Entities.ProfessorEntity;
import com.collegeManagementSystem.mappingJPA.Exception.ResourceNotFoundException;
import com.collegeManagementSystem.mappingJPA.Repository.ProfessorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/professors")
@Validated
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    private List<ProffessorDTO> getAllProfessors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    )
    {
        Pageable pageable = PageRequest.of(page,size,Sort.by(sortBy));

        Page<ProfessorEntity> professors = professorRepository.findAll(pageable);

        return professors.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<ProffessorDTO> createProfessor(@RequestBody @Valid ProffessorDTO proffessorDTO)
    {
        ProfessorEntity professor = mapToProfessor(proffessorDTO);

        ProfessorEntity savedProfessor = professorRepository.save(professor);
        return new ResponseEntity<>(mapToDTO(savedProfessor), HttpStatus.CREATED);
    }

    public ProfessorEntity mapToProfessor(ProffessorDTO proffessorDTO)
    {
        ProfessorEntity professorEntity = new ProfessorEntity();
        professorEntity.setId(proffessorDTO.getId());
        professorEntity.setTitle(proffessorDTO.getTitle());

        return professorEntity;
    }

    public  ProffessorDTO mapToDTO(ProfessorEntity professorEntity)
    {
        ProffessorDTO professorDTO = new ProffessorDTO();
        professorDTO.setId(professorEntity.getId());
        professorDTO.setTitle(professorEntity.getTitle());
        // Map other fields if needed
        return professorDTO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProffessorDTO> getProfessorById(@PathVariable Long id)
    {
        ProfessorEntity professor = professorRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Professor not Found with id:"+ id));

        return new ResponseEntity<>(mapToDTO(professor),HttpStatus.OK);
    }
}
