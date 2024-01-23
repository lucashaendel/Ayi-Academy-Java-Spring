package com.quinceenero.ejerciciodos.clientes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private int nroCliente;
    private String nombre;
    private String apellido;
    private String telefono;

}
