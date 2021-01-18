package com.iranargham.first.repository;


import com.iranargham.first.client.dto.TerminalDto;
import com.iranargham.first.entity.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Long> {


    Optional<Terminal> findByTerminalName(String terminalName);
}

