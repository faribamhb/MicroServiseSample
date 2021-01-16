package com.iranargham.first.controller;

import com.iranargham.first.entity.Terminal;
import com.iranargham.first.repository.TerminalRepository;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${info.first.rest.version}")
public class TerminalController {

    private final TerminalRepository terminalRepository;

    public TerminalController(TerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }

    @GetMapping(value = "/showTerminal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Terminal>> getAllBranches(){

        return new ResponseEntity<>(terminalRepository.findAll(), HttpStatus.OK);
    }

}
