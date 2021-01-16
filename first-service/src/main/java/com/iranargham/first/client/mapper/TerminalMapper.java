package com.iranargham.first.client.mapper;

import com.iranargham.first.client.dto.TerminalDto;
import com.iranargham.first.entity.Terminal;


//@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TerminalMapper {

    Terminal TerminalDtoTOTerminal(TerminalDto terminalDto);
}
