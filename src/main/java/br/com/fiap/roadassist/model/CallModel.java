package br.com.fiap.roadassist.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_call_winch")
public class CallModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "reason_call")
    private String reasonCall;

    @Column(name = "time_call")
    private LocalDateTime timeCall;

    @Column(name = "situation_call")
    private String situationCall;

    @Column(name = "vehicle_id")
    private UUID vehicle;

    @Column(name = "winch_id")
    private UUID winch;

    @Column(name = "start_address_id")
    private UUID startAddress;

    @Column(name = "end_address_id")
    private UUID endAddress;

}
