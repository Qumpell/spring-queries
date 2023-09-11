package com.example.domain.client;

import com.example.domain.client.clientall.ClientAllController;
import com.example.domain.client.clientall.service.impl.ClientAllService;
import com.example.domain.client.clientone.service.impl.ClientOneService;
import com.example.domain.client.update.mapper.ClientResponseMapper;
import com.example.dto.ClientResponse;
import com.example.exception.EntityNotFoundException;
import com.example.model.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientAllController.class)
class ClientAllControllerTest {

    @MockBean
    private ClientAllService clientAllService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void should_Return_All_Clients_When_Clients_Exists() throws Exception {
        //given
        ClientResponse client1 = ClientResponse.builder()
                .login("testLogin")
                .name("Jan")
                .surname("Kowalski")
                .generation("Alpha")
                .build();
        ClientResponse client2 = ClientResponse.builder()
                .login("testLogin")
                .name("Jan")
                .surname("Kowalski")
                .generation("Alpha")
                .build();
        List<ClientResponse> clientResponseList = List.of(client1,client2);
        given(clientAllService.getAllClients()).willReturn(clientResponseList);
        //when //then
        mockMvc.perform(get("/client/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*").exists())
                .andExpect(jsonPath("$.*").isArray());

        verify(clientAllService,  times(1)).getAllClients();
    }

    @Test
    public void should_Return_No_Content_When_Clients_Do_Not_Exist() throws Exception {
        //given
        List<ClientResponse> clientResponseList = Collections.emptyList();
        given(clientAllService.getAllClients()).willReturn(clientResponseList);

        //when //then
        mockMvc.perform(get("/client/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$.*").doesNotExist());

        verify(clientAllService, times(1)).getAllClients();
    }

}