package com.teamphoenix.ahub.fair.command.repository;

import com.teamphoenix.ahub.fair.command.aggregate.Fair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FairRepository extends JpaRepository<Fair, Integer> {

}
