package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.reposioties.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetUseCaseTest {

    @MockBean
    private QuestionRepository questionRepository;
    @SpyBean
    private GetUseCase getQuestion;

    @Test
    void get(){

        var questionDTO = new QuestionDTO("1","1","React o Angular?","OPEN",
                "TECNOLOGIA",1,2, Arrays.asList("1", "2"),  "juandi@gmail.com");


        var question= new Question();
        question.setId("1");
        question.setQuestion("React o Angular?");
        question.setUserId("1");
        question.setType("OPEN");
        question.setCategory("ECNOLOGIA");

        Mockito.when(questionRepository.findById(Mockito.any(String.class))).thenReturn(Mono.just(question));

        var result = getQuestion.apply("1");
        Assertions.assertEquals(Objects.requireNonNull(result.block()).getQuestion(), "React o Angular?");
    }

}