package br.com.fiap.petcall.controllers95174;

import br.com.fiap.petcall.models95174.Petcall;
import br.com.fiap.petcall.repositories95174.PetcallRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/tutores")
public class TutorController {

	@Autowired
    private PetcallRepository tutorRepository;

//    @Autowired
//    public TutorController(PetcallRepository tutorRepository) {
//        this.tutorRepository = tutorRepository;
//    }

    @GetMapping("/listar")
    public String listarTutores(Model model) {
        List<Petcall> tutores = tutorRepository.findAll();
        model.addAttribute("tutores", tutores);
        return "petcall/listar-tutores";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormEdicao(@PathVariable("id") Long id, Model model) {
        Petcall tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tutor inválido: " + id));
        model.addAttribute("tutor", tutor);
        return "petcall/editar-tutor";
    }

    @PostMapping("/editar/{id}")
    public String editarTutor(@PathVariable("id") Long id, @Valid Petcall tutor, BindingResult result) {
        if (result.hasErrors()) {
            return "petcall/editar-tutor";
        }
        tutor.setId(id);
        tutorRepository.save(tutor);
        return "redirect:/tutores/listar";
    }

    @GetMapping("/delete/{id}")
    public String deletarTutor(@PathVariable("id") Long id) {
        Petcall tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tutor inválido: " + id));
        tutorRepository.delete(tutor);
        return "redirect:/tutores/listar";
    }

}
