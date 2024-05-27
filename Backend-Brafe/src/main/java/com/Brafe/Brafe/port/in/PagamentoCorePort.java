package com.Brafe.Brafe.port.in;

import com.Brafe.Brafe.adapter.in.model.Pagamento;

public interface PagamentoCorePort {
    boolean salvarPagamento(Pagamento pagamentoRequest);
}