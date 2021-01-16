package com.iranargham.first.controller;

import com.iranargham.first.client.dto.TerminalDto;
import com.iranargham.first.entity.Terminal;
import com.iranargham.first.repository.TerminalRepository;
import com.iranargham.first.service.TerminalService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "${info.first.rest.version}")
public class TerminalController {

    private final TerminalRepository terminalRepository;
    private final TerminalService terminalService;

    public TerminalController(TerminalRepository terminalRepository, TerminalService terminalService) {
        this.terminalRepository = terminalRepository;
        this.terminalService = terminalService;
    }

    @GetMapping(value = "/showTerminal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Terminal>> getAllBranches(){

        return new ResponseEntity<>(terminalRepository.findAll(), HttpStatus.OK);
    }


    @PostMapping(value = "/addTerminal", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<TerminalDto> searchAtmBranch(@Valid @RequestBody TerminalDto terminalDto) throws ServiceException {
        return new ResponseEntity<>(terminalService.insertTerminal(terminalDto), HttpStatus.OK);
    }


}
