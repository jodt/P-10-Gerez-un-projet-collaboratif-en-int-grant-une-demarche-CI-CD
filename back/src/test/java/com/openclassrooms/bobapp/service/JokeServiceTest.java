package com.openclassrooms.bobapp.service;

import com.openclassrooms.bobapp.data.JsonReader;
import com.openclassrooms.bobapp.model.Joke;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JokeServiceTest {

    @Mock
    private JsonReader jsonReader;

    @InjectMocks
    private JokeService jokeService;

    @Test
    void getRandomJoke() {
        Joke firstJoke = new Joke("Que demande un footballeur à son coiffeur ?", "La coupe du monde s’il vous plait");
        Joke othertJoke = new Joke("Pourquoi les Belges viennent-ils à la messe avec du savon ?", "Pour l’Ave Maria.");

        when(jsonReader.getJokes()).thenReturn(List.of(firstJoke, othertJoke));

         Joke result = jokeService.getRandomJoke();
         assertNotNull(result);
    }

}