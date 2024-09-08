package com.vnny8.designpatternsDIO.service;

import com.vnny8.designpatternsDIO.model.Cliente;
import com.vnny8.designpatternsDIO.model.Endereco;
import com.vnny8.designpatternsDIO.repository.ClienteRepository;
import com.vnny8.designpatternsDIO.repository.EnderecoRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    public void criar(Cliente cliente){

        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep)
                .orElseGet(() -> {
                    Endereco enderecoSalvar = viaCepService.consultarCep(cep);
                    enderecoRepository.save(enderecoSalvar);
                    return enderecoSalvar;
                });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    public void deletar(Long id){
        clienteRepository.findById(id).orElseThrow();
        clienteRepository.deleteById(id);
    }

    public Cliente buscarPorId(Long id){
        return clienteRepository.findById(id).orElseThrow();
    }

    public void editar(Cliente cliente, Long id) throws BadRequestException {
        Cliente clienteBanco = clienteRepository.findById(id).orElseThrow(BadRequestException::new);
        if (cliente.getNome() != null){
            clienteBanco.setNome(cliente.getNome());
        }
        if (cliente.getEndereco() != null){
            clienteBanco.setEndereco(cliente.getEndereco());
        }
        clienteRepository.save(clienteBanco);
    }
}
