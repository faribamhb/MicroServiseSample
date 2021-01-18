package com.iranargham.first.client.mapper;

import com.iranargham.first.client.dto.TerminalDto;
import com.iranargham.first.entity.Terminal;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TerminalMapper {

    Terminal TerminalDtoTOTerminal(TerminalDto terminalDto);

    TerminalDto terminalToTerminalDto(Terminal save);
}
