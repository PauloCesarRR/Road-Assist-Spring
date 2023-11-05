package br.com.fiap.roadassist.model;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_call_winch")
public class CallModel {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqcall")
    @SequenceGenerator(name="seqcall", sequenceName="sequence_call",initialValue=1,allocationSize=1)
    private Integer id;

    @Column(name = "reason_call")
    private String reasonCall;

    @Column(name = "time_call")
    private LocalDateTime timeCall;

    @Column(name = "situation_call")
    private String situationCall;
   
    @ManyToOne
	@JoinColumn(name = "vehicle_id")
	private VehicleModel vehicle;

    @ManyToOne
	@JoinColumn(name = "winch_id")
	private WinchModel winch;

    @ManyToOne
	@JoinColumn(name = "start_address_id")
	private AddressModel startAddress;

    @ManyToOne
	@JoinColumn(name = "end_address_id")
	private AddressModel endAddress;
}
