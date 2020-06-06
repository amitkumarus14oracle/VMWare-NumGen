package com.vmware.numbergenerator.repository;

import com.vmware.numbergenerator.model.GeneratedNumber;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface NumGenRepository extends CrudRepository<GeneratedNumber, UUID> {
}
