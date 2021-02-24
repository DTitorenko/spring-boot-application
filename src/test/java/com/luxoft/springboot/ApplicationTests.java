package com.luxoft.springboot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.luxoft.springboot.controller.OrderController;
import com.luxoft.springboot.model.Order;
import com.luxoft.springboot.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@SpringJUnitConfig
@AutoConfigureMockMvc
class ApplicationTests {

    @Autowired
    MockMvc mockMvc;

    // TODO: 24.02.2021
//    @Test
//    void contextLoads() {
//    }

    ObjectMapper objectMapper = new ObjectMapper();
    Order order = new Order(1, 100500, "name1", "name2");
    List<Order> orderList = Collections.singletonList(order);

    @Test
    void testAddOrder() throws Exception {
        String object = objectMapper.writer().writeValueAsString(order);
        this.mockMvc
                .perform(post("/order")
                        .content(object)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNoContent());
    }

    @Test
    void testAddAllOrder() throws Exception {
        String list = objectMapper.writer().writeValueAsString(orderList);
        this.mockMvc
                .perform(put("/order")
                        .content(list)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNoContent());
    }

    @Test
    void testGetOrder() throws Exception {
        this.mockMvc
                .perform(get("/order/" + order.getId()))
                .andExpect(status().isFound());
    }

    @Test
    void testGetAllOrder() throws Exception {
        this.mockMvc
                .perform(get("/order/all"))
                .andExpect(status().isFound());
    }

    @Test
    void testUploadXML() throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        String object = xmlMapper.writeValueAsString(order);
        this.mockMvc.perform(post("/order/upload")
                .content(object)
                .contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(status().isAccepted());
    }

    @Test
    void testUploadAny() throws Exception {
        String object = objectMapper.writeValueAsString(order);
        this.mockMvc.perform(post("/order/upload")
                .content(object))
                .andExpect(content().string(containsString("Wrong format.")));
    }
}
