package com.iranargham.first.client.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@Getter  //Generates getters
@Setter
public class TerminalDto implements Serializable {
    private char active;
    private String  terminalName;
    private String  description;
    private Long  terminalNumber;


    @Override
    public String toString() {
        return "TerminalDto{" +
                "active='" + active + '\'' +
                ", terminalName=" + terminalName +
                ", description='" + description + '\'' +
                ", terminalNumber='" + terminalNumber + '\'' +
                '}';
    }
}
