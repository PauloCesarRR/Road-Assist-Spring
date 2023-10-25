package br.com.fiap.roadassist.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
   
    @ManyToOne
	@JoinColumn(name = "call_winch_vehicle_fk")
	private VehicleModel vehicle;

    @ManyToOne
	@JoinColumn(name = "call_winch_winch_fk")
	private WinchModel winch;

    @ManyToOne
	@JoinColumn(name = "call_winch_start_address_fk")
	private AddressModel startAddress;

    @ManyToOne
	@JoinColumn(name = "call_winch_end_address_fk")
	private AddressModel endAddress;
}
