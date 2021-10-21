import React from 'react'

export const Answer = ({ answer, userId, onDelete }) => (
  <aside className="answer">
    <p>{answer.answer}</p>
    {answer.userId === userId && <button className="btb-delete-answer" onClick={()=>{onDelete(answer.id)}}>Eliminar</button>}
  </aside>
)
