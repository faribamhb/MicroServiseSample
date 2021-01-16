package com.iranargham.first.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class TerminalDto implements Serializable {
    private char active;
    private String  terminalName;
    private String  description;
    private Long  terminalNumber;
}
