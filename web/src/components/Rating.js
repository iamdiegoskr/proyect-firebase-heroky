import React from "react";

function Rating({ question }) {
  const average = Math.round(
    question.sumOfReviewScores / question.numberOfReviews
  );

  switch (average) {
    case 1:
      return <div>{`\u{1f641}`}</div>;
      break;

    case 2:
      return <div>{`\u{1f610}`}</div>;
      break;

    case 3:
      return <div>{`\u{1f600}`}</div>;
      break;
    default:
      return <div></div>;
  }
}

export default Rating;