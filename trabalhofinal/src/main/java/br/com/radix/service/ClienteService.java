package br.com.radix.service;

import br.com.radix.entity.Cliente;
import br.com.radix.entity.Conta;
import br.com.radix.entity.Operacao;
import br.com.radix.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> listaCliente() {
        return clienteRepository.findAll();
    }

    public Cliente salvarCliente(Cliente clienteAdd) {

        return clienteRepository.save(clienteAdd);

    }

    public void deleteCliente(String id) {
        clienteRepository.delete(id);
    }

    public Cliente getById(String id) {

        return clienteRepository.findOne(id);
    }

    public Cliente getByNome(String nome) {

        return clienteRepository.findOne(nome);
    }


    public Cliente depositaSaldo(String usuario, Operacao operacao) {

        Cliente cliente = this.getByNome(usuario);

        if (cliente == null) {
            return null;
        }

        List<Conta> listContas = new ArrayList<>();

        for (Conta contas: cliente.getContas()) {
            String tipoDaConta = contas.getTipoConta();

            if (operacao.tipoConta.equals(tipoDaConta)) {
                contas.setSaldo(this.deposito(contas.getSaldo(), operacao.valor));
            }
            listContas.add(contas);
        }
        cliente.setContas(null);
        cliente.setContas(listContas);

        return this.salvarCliente(cliente);
    }

    private BigDecimal deposito(BigDecimal valor, BigDecimal valor2) {

        BigDecimal saldo = valor;
        BigDecimal saldo2 = valor2;
        BigDecimal result = saldo.add(saldo2);

        return result;
    }
}
