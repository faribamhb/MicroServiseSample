package com.iranargham.first.service;

import com.iranargham.first.client.dto.TerminalDto;

import com.iranargham.first.client.mapper.TerminalMapper;
import com.iranargham.first.entity.Terminal;
import com.iranargham.first.repository.TerminalRepository;
import org.springframework.stereotype.Service;

@Service
public class TerminalService {


    private final TerminalMapper terminalMapper;
    private final TerminalRepository terminalRepository;

    public TerminalService(TerminalMapper terminalMapper, TerminalRepository terminalRepository) {
        this.terminalMapper = terminalMapper;
        this.terminalRepository = terminalRepository;
    }

    public TerminalDto insertTerminal(TerminalDto terminalDto) {
       return terminalMapper.terminalToTerminalDto(terminalRepository.save(terminalMapper.TerminalDtoTOTerminal(terminalDto)));


    }
}
