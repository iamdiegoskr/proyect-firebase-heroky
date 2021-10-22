import React from 'react'
import { Link } from 'react-router-dom'

const HomePage = ({children}) => (
  <section>
    <h1>Home</h1>
    <div>
      {children}
    </div>
    <p>welcome to the question and answer app.</p>
    <div className="container-image">
      <img src="questionhome.svg" alt='home'/>
    </div>
    <Link to="/questions" className="button">
      View Questions
    </Link>

  </section>
)
export default HomePage
