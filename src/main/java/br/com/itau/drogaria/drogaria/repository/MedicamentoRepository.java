package br.com.itau.drogaria.drogaria.repository;

import br.com.itau.drogaria.drogaria.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    public List<Medicamento> findAllByNomeContainingIgnoreCase(String nome);
    public List<Medicamento> findByFabricanteEquals(String fabricante);
    public List<Medicamento> findByPrecoLessThanOrderByPrecoDesc(BigDecimal preco);

}
