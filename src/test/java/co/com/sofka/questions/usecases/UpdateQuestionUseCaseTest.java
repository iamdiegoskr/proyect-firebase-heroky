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
class UpdateQuestionUseCaseTest {

    @SpyBean
    private UpdateQuestionUseCase updateQuestionUseCase;

    @MockBean
    private QuestionRepository repository;

    @Test
    void updateQuestionTest(){

        var questionDTO = new QuestionDTO("xxx","yyy","React o Angular","OPEN",
                "TECNOLOGIA",1,2, Arrays.asList("x1", "x2"),  "juandi@gmail.com");

        var question = new Question();
        question.setId("xxx");
        question.setUserId("yyy");
        question.setQuestion("React o Angular");
        question.setType("OPEN");
        question.setCategory("LENGUAJE");
        question.setNumberOfReviews(1);
        question.setSumOfReviewScores(2);
        question.setUserReviews(Arrays.asList("x1","x2"));
        question.setUserEmail("juandi@gmail.com");

        when(repository.save(Mockito.any(Question.class))).thenReturn(Mono.just(question));

        var result = updateQuestionUseCase.apply(questionDTO);

        Assertions.assertEquals(Objects.requireNonNull(result.block()).getId(),"xxx");
        Assertions.assertEquals(Objects.requireNonNull(result.block()).getUserId(),"yyy");
        Assertions.assertEquals(Objects.requireNonNull(result.block()).getQuestion(),"React o Angular");
        Assertions.assertEquals(Objects.requireNonNull(result.block()).getType(),"OPEN");
        Assertions.assertEquals(Objects.requireNonNull(result.block()).getCategory(),"LENGUAJE");
        Assertions.assertEquals(Objects.requireNonNull(result.block()).getUserEmail(),"juandi@gmail.com");
        Assertions.assertEquals(Objects.requireNonNull(result.block()).getNumberOfReviews(),1);
        Assertions.assertEquals(Objects.requireNonNull(result.block()).getSumOfReviewScores(),2);

    }


}