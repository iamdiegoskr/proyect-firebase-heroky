package co.com.sofka.questions.usecases;

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

import java.util.Arrays;


@SpringBootTest
class DeleteUseCaseTest {

    @MockBean
    private AnswerRepository answerRepository;
    @MockBean
    private QuestionRepository questionRepository;

    @SpyBean
    DeleteUseCase deleteQuestionUseCase;


    @Test
    void deleteQuestionTest() {
        var resourceDT0 = new QuestionDTO("xxx", "yyy", "Que es Java?", "OPEN",
                "TECNOLOGIA", 1, 2, Arrays.asList("xxx1", "xxx2"), "daniela.03v@gmail.com");

        var resource = new Question();
        resource.setId("xxx");
        resource.setUserId("yyy");
        resource.setQuestion("Que es Java?");
        resource.setType("OPEN");
        resource.setCategory("TECNOLOGIA");
        resource.setNumberOfReviews(1);
        resource.setSumOfReviewScores(1);
        resource.setUserReviews(Arrays.asList("xxx1", "xxx2"));
        resource.setUserEmail("daniela.03v@gmail.com");

        Mockito.when(questionRepository.deleteById("xxx")).thenReturn(Mono.empty());
        Mockito.when(answerRepository.deleteByQuestionId("xxx")).thenReturn(Mono.empty());

        var result = deleteQuestionUseCase.apply("xxx").block();
        Assertions.assertEquals(result,null);
    }

}