package co.com.sofka.questions.usecases;

import co.com.sofka.questions.model.AnswerDTO;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.reposioties.AnswerRepository;
import co.com.sofka.questions.reposioties.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeleteUseCaseTest {

    @MockBean
    private AnswerRepository answerRepository;
    @MockBean
    private QuestionRepository questionRepository;

    @SpyBean
    DeleteUseCase deleteQuestionUseCase;


    @Test
    void delete(){


        var questionDTO = new QuestionDTO("1","1","React o Angular","OPEN",
                "TECNOLOGIA",1,2, Arrays.asList("1", "2"),  "juandi@gmail.com");

        var answer = new AnswerDTO();
        answer.setQuestionId("1");
        answer.setUserId("1");
        answer.setAnswer("It's a programming language");

        Mockito.when(questionRepository.deleteById("1")).thenReturn(Mono.empty());
        Mockito.when(answerRepository.deleteByQuestionId("1")).thenReturn(Mono.empty());

        var result = deleteQuestionUseCase.apply("1").block();

        Assertions.assertEquals(result,null);
    }

}