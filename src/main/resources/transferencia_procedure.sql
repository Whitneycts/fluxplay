-- Script PostgreSQL para transferencia com rollback automatico.
-- Em caso de erro, a excecao faz rollback da transacao em execucao.

CREATE TABLE IF NOT EXISTS conta (
    id BIGSERIAL PRIMARY KEY,
    titular VARCHAR(120) NOT NULL,
    saldo NUMERIC(15, 2) NOT NULL DEFAULT 0 CHECK (saldo >= 0)
);

CREATE OR REPLACE PROCEDURE realizar_transferencia(
    p_conta_origem_id BIGINT,
    p_conta_destino_id BIGINT,
    p_valor NUMERIC(15, 2)
)
LANGUAGE plpgsql
AS $$
DECLARE
    v_saldo_origem NUMERIC(15, 2);
BEGIN
    IF p_conta_origem_id = p_conta_destino_id THEN
        RAISE EXCEPTION 'Conta de origem e destino devem ser diferentes';
    END IF;

    IF p_valor IS NULL OR p_valor <= 0 THEN
        RAISE EXCEPTION 'Valor da transferencia deve ser maior que zero';
    END IF;

    -- Lock pessimista para evitar condicao de corrida.
    SELECT saldo
      INTO v_saldo_origem
      FROM conta
     WHERE id = p_conta_origem_id
     FOR UPDATE;

    IF NOT FOUND THEN
        RAISE EXCEPTION 'Conta de origem % nao encontrada', p_conta_origem_id;
    END IF;

    PERFORM 1
      FROM conta
     WHERE id = p_conta_destino_id
     FOR UPDATE;

    IF NOT FOUND THEN
        RAISE EXCEPTION 'Conta de destino % nao encontrada', p_conta_destino_id;
    END IF;

    IF v_saldo_origem < p_valor THEN
        RAISE EXCEPTION 'Saldo insuficiente na conta de origem';
    END IF;

    UPDATE conta
       SET saldo = saldo - p_valor
     WHERE id = p_conta_origem_id;

    UPDATE conta
       SET saldo = saldo + p_valor
     WHERE id = p_conta_destino_id;

EXCEPTION
    WHEN OTHERS THEN
        -- Repropaga o erro para garantir rollback da transacao.
        RAISE;
END;
$$;

-- Exemplo de uso:
-- CALL realizar_transferencia(1, 2, 100.00);
