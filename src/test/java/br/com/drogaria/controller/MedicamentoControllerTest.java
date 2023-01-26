package br.com.drogaria.controller;

import br.com.drogaria.controller.request.MedicamentoRequest;
import br.com.drogaria.controller.response.MedicamentoResponse;
import br.com.drogaria.controller.MedicamentoController;
import br.com.drogaria.service.MedicamentoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class MedicamentoControllerTest {

    @InjectMocks
    private MedicamentoController medicamentoController;

    @Mock
    private MedicamentoService medicamentoServiceMock;

    @Test
    void listAllSuccess() {
        //given, when, then
        var response = medicamentoController.listAll();

        BDDMockito.when(medicamentoServiceMock.listAll()).thenReturn(List.of(MedicamentoResponse.builder().build()));

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    @Disabled
    void listAllError() {
        var response = medicamentoController.listAll();

        BDDMockito.when(medicamentoServiceMock.listAll()).thenThrow(new RuntimeException());

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


    @Test
    void saveSuccess() {
        var medicamentoRequest = new MedicamentoRequest();
        var response = medicamentoController.save(medicamentoRequest);

        BDDMockito.when(medicamentoServiceMock.save(ArgumentMatchers.any())).thenReturn(MedicamentoResponse.builder().build());

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }


    @Test
    void deleteSuccess() {
        var id = 1L;
        var response = medicamentoController.delete(1L);

        BDDMockito.doNothing().when(medicamentoServiceMock).delete(ArgumentMatchers.anyLong());

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}