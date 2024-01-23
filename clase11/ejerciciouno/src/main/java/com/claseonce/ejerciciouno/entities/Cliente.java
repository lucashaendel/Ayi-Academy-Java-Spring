package com.claseonce.ejerciciouno.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente {

    private int numeroCliente;
    private String nombre;
    private String apellido;


}
