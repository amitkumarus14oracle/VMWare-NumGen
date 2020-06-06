package com.vmware.numbergenerator.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class GeneratedNumber {
    @Id
    private UUID uuid;
    private String sequence;

    public GeneratedNumber() {
    }

    public GeneratedNumber(UUID uuid, String sequence) {
        this.uuid = uuid;
        this.sequence = sequence;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}
