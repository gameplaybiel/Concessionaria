package br.project.Concessionaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConcessionariaController {

    @Autowired ConcessionariaDao dao;

    @GetMapping("/concessionaria")
    public List<Concessionaria> listar() throws Exception {
        return dao.listar();
    }
    @GetMapping("/concessionaria/{id}")
    public Concessionaria obter(@PathVariable int id) throws Exception {
        return dao.obter(id);
    }
    @PostMapping("/concessionaria")
    public Concessionaria incluir(@RequestBody Concessionaria c) throws Exception {
        return dao.incluir(c);
    }
}
