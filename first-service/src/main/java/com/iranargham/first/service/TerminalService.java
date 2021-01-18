package com.iranargham.first.service;

import com.iranargham.first.client.dto.TerminalDto;

import com.iranargham.first.client.mapper.TerminalMapper;
import com.iranargham.first.common.data.SearchUtils;
import com.iranargham.first.common.data.SearchablePage;
import com.iranargham.first.common.exceptions.ErrorCodes;
import com.iranargham.first.common.exceptions.ServiceException;
import com.iranargham.first.entity.Terminal;
import com.iranargham.first.repository.TerminalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class TerminalService {
    private static final Logger logger = LoggerFactory.getLogger(TerminalService.class);


    private final TerminalMapper terminalMapper;
    private final TerminalRepository terminalRepository;

    public TerminalService(TerminalMapper terminalMapper, TerminalRepository terminalRepository) {
        this.terminalMapper = terminalMapper;
        this.terminalRepository = terminalRepository;
    }

    public TerminalDto insertTerminal(TerminalDto terminalDto) {
        logger.info("REST request to save terminal : {}", terminalDto);
       return terminalMapper.terminalToTerminalDto(terminalRepository.save(terminalMapper.terminalDtoTOTerminal(terminalDto)));


    }

    public TerminalDto findByTerminalName(String terminalName) throws ServiceException {

        Terminal terminal = terminalRepository.findByTerminalName(terminalName).orElseThrow(() -> new ServiceException("Terminal cannot be found in client"+terminalName, ErrorCodes.NO_ENTITY.getCode()));
       return terminalMapper.terminalToTerminalDto(terminal);
    }

    public Page<Terminal> findAllTerminalPage(SearchablePage searchablePage) throws ServiceException {
      return   terminalRepository.findAll(SearchUtils.getPageRequest(searchablePage));
    }
}
