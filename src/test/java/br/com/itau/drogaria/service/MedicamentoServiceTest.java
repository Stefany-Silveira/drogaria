package br.com.itau.drogaria.service;

import br.com.itau.drogaria.adapter.MedicamentoAdapter;
import br.com.itau.drogaria.controller.request.MedicamentoRequest;
import br.com.itau.drogaria.model.Medicamento;
import br.com.itau.drogaria.repository.MedicamentoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static br.com.itau.drogaria.util.ToolBuilder.toolBuild;
import static br.com.itau.drogaria.util.ToolBuilder.toolResponseBuild;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class MedicamentoServiceTest {

    @InjectMocks
    private MedicamentoService medicamentoService;

    @Mock
    private MedicamentoRepository medicamentoRepositoryMock;

    @Mock
    private MedicamentoAdapter medicamentoAdapterMock;

    @Test
    void listAllSuccess() {
        //when, given, then
        BDDMockito.when(medicamentoRepositoryMock.findAll()).thenReturn(List.of(toolBuild()));
        BDDMockito.when(medicamentoAdapterMock.toMedicamentoResponse(any())).thenReturn(toolResponseBuild());

        var response = medicamentoService.listAll();

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.get(0).getTitle()).isEqualTo("Google");
    }

    @Test
    void findByTagSuccess() {
        BDDMockito.when(medicamentoRepositoryMock.findAll()).thenReturn(List.of(toolBuild()));
        BDDMockito.when(medicamentoAdapterMock.toMedicamentoResponse(any())).thenReturn(toolResponseBuild());

        var response = medicamentoService.findByTag("web");

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.get(0).getTags()).contains("web");
    }

    @Test
    void findByTagEmpty() {
        BDDMockito.when(medicamentoRepositoryMock.findAll()).thenReturn(List.of(toolBuild()));
        BDDMockito.when(medicamentoAdapterMock.toMedicamentoResponse(any())).thenReturn(toolResponseBuild());

        var response = medicamentoService.findByTag("dev");

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response).hasSize(0);
    }

    @Test
    void saveSuccess() {
        BDDMockito.when(medicamentoAdapterMock.toMedicamento(any(MedicamentoRequest.class))).thenReturn(toolBuild());
        BDDMockito.when(medicamentoAdapterMock.toMedicamentoResponse(any(Medicamento.class))).thenReturn(toolResponseBuild());
        BDDMockito.when(medicamentoRepositoryMock.save(any(Medicamento.class))).thenReturn(toolBuild());

        var response = medicamentoService.save(new MedicamentoRequest());

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getTitle()).isEqualTo("Google");
        Assertions.assertThat(response.getDescription()).isEqualTo("Ferramenta de pesquisa");
        Assertions.assertThat(response.getTags()).contains("navegador");
    }

    @Test
    void deleteSuccess() {
        BDDMockito.when(medicamentoRepositoryMock.findById(anyLong())).thenReturn(Optional.of(toolBuild()));
        BDDMockito.doNothing().when(medicamentoRepositoryMock).delete(ArgumentMatchers.any(Medicamento.class));

        Assertions.assertThatCode(() -> medicamentoService.delete(1L)).doesNotThrowAnyException();
    }

    @Test
    void deleteThrowsException() {
        BDDMockito.when(medicamentoRepositoryMock.findById(anyLong())).thenThrow(new RuntimeException());

        Assertions.assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> medicamentoService.delete(1L));
    }

}