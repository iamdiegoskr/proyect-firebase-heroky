package co.com.sofka.questions.usecases;

import co.com.sofka.questions.reposioties.AnswerRepository;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

public class DeleteAnswerUseCase implements Function<String, Mono<Void>> {

    private final AnswerRepository repository;

    public DeleteAnswerUseCase(AnswerRepository repository){
        this.repository = repository;
    }

    @Override
    public Mono<Void> apply(String id) {
        Objects.requireNonNull(id,"El id es requerido");
        return repository.deleteById(id);
    }
}
