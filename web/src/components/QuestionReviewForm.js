import React from "react";
import { connect } from "react-redux";
import { postReview } from "../actions/questionActions";

import { useForm } from "react-hook-form";
import Rating from "./Rating";

function QuestionReviewForm({ question, user, dispatch, loading, hasErrors }) {
  const { register, handleSubmit } = useForm();

  const onSubmit = (data) => {
    dispatch(postReview(data.review, question.id, user));
  };

  const renderQuestions = () => {
    console.log(question.userReviews);
    return question.userReviews?.includes(user);
  };
  if (loading) return <p>Loading ...</p>;
  if (hasErrors) return <p>Unable to display questions.</p>;

  return (
    <section className="section-review">
      {renderQuestions() || user === null ? (
        <div>
          Promedio de la pregunta: <Rating question={question} />
        </div>
      ) : (
        <form onSubmit={handleSubmit(onSubmit)} className="form-review">
          <label for="review">Calificar pregunta</label>
          <select {...register("review")} id="">
            <option value=""> Seleccionar...</option>
            <option value="1">{`\u{1f641}`}</option>
            <option value="2"> {`\u{1f610}`}</option>
            <option value="3"> {`\u{1f600}`}</option>
          </select>
          <button type="submit" className="btn-review">
            Enviar votacion
          </button>
        </form>
      )}
    </section>
  );
}

const mapStateToProps = (state) => ({
  loading: state.question.loading,
  hasErrors: state.question.hasErrors,
  question: state.question.question,
  user: state.auth.uid,
});

export default connect(mapStateToProps)(QuestionReviewForm);