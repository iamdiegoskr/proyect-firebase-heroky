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

import static org.mockito.Mockito.when;

@SpringBootTest
class CreateUseCaseTest {

    @SpyBean
    private CreateUseCase createUseCase;

    @MockBean
    private QuestionRepository repository;

    @Test
    void createQuestion(){

        var questionDTO = new QuestionDTO("xxx","yyy","React o Angular","tecnologia",
                "TECNOLOGIA",1,2, Arrays.asList("x1", "x2"),  "juandi@gmail.com");

        var question = new Question();
        question.setId("xxx");
        question.setUserId("yyy");
        question.setQuestion("React o Angular");
        question.setType("tecnologia");
        question.setCategory("TECNOLOGIA");
        question.setNumberOfReviews(1);
        question.setSumOfReviewScores(2);
        question.setUserReviews(Arrays.asList("x1","x2"));
        question.setUserEmail("juandi@gmail.com");

        when(repository.save(Mockito.any(Question.class))).thenReturn(Mono.just(question));

        var result = createUseCase.apply(questionDTO);

        Assertions.assertEquals(Objects.requireNonNull(result.block()),"xxx");
    }

}