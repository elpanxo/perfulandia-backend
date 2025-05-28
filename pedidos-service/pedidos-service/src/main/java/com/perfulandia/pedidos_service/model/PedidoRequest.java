package com.perfulandia.pedidos_service.model.dto;

import lombok.Data;
import java.util.List;

@Data
public class PedidoRequest {
    private Long usuarioId;
    private List<ItemPedidoRequest> items;
}