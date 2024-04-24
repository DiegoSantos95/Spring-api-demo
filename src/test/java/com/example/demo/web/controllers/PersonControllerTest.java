package com.example.demo.web.controllers;

import com.example.demo.models.Person;
import com.example.demo.services.PersonService;
import com.example.demo.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    public void createPerson() throws Exception{
        Person person = new Person();
        person.setName("Diego");

         given(personService.create(person)).willReturn(person);

         mockMvc.perform(post("/person")
                 .contentType(MediaType.APPLICATION_JSON_VALUE)
                 .content(JsonUtil.toJson(person)))
                 .andExpect(status().isCreated());
    }

    @Test
    public void createPerson_whenMissingName() throws Exception{
        Person person = new Person();

        given(personService.create(person)).willReturn(person);

        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(JsonUtil.toJson(person)))
                .andExpect(status().isBadRequest());
    }

}
