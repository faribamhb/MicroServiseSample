package com.iranargham.first.controller;

import com.iranargham.first.client.dto.TerminalDto;
import com.iranargham.first.common.data.SearchablePage;
import com.iranargham.first.common.exceptions.ServiceException;
import com.iranargham.first.entity.Terminal;
import com.iranargham.first.repository.TerminalRepository;
import com.iranargham.first.service.TerminalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<List<Terminal>> findAllTerminal(){

        return new ResponseEntity<>(terminalRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/showAllTerminal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Terminal>> findAllTerminalPage(@RequestParam int page,
                                                              @RequestParam int total,
                                                              @RequestParam(required = false) String order,
                                                              @RequestParam(required = false) String direction) throws ServiceException {
        Map<String, String> query = new HashMap<>();
        SearchablePage searchablePage = SearchablePage.builder()
                .page(page).order(order).total(total).direction(direction).filter(query).build();
        return new ResponseEntity<>(terminalService.findAllTerminalPage(searchablePage), HttpStatus.OK);
    }


    @PostMapping(value = "/addTerminal", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<TerminalDto> insertTerminal(@Valid @RequestBody TerminalDto terminalDto) throws ServiceException {
        return new ResponseEntity<>(terminalService.insertTerminal(terminalDto), HttpStatus.OK);
    }



    @GetMapping(value = "/findByTerminalName/{terminalName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminalDto> findByTerminalName(@PathVariable String terminalName) throws ServiceException {
        return new ResponseEntity<>(terminalService.findByTerminalName(terminalName), HttpStatus.OK);
    }

}
