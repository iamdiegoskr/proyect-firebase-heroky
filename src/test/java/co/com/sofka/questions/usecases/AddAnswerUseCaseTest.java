package co.com.sofka.questions.usecases;

import co.com.sofka.questions.collections.Answer;
import co.com.sofka.questions.collections.Question;
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

import java.util.Objects;

import static org.mockito.Mockito.when;

@SpringBootTest
class AddAnswerUseCaseTest {

    @SpyBean
    private AddAnswerUseCase createUseCase;

    @MockBean
    private AnswerRepository repository;

    @Test
    void createAnswer(){
        var answerDTO = new AnswerDTO("xxx","yyy","zzz","Es una libreria");

        var answer = new Answer();
        answer.setId("xxx");
        answer.setQuestionId("yyy");
        answer.setUserId("zzz");
        answer.setAnswer("Es una libreria");

        when(repository.save(Mockito.any(Answer.class))).thenReturn(Mono.just(answer));

        var result = createUseCase.apply(answerDTO);

        Assertions.assertEquals(Objects.requireNonNull(result.block()).getId(),"yyy");
    }

}