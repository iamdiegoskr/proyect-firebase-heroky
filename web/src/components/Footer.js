import React from 'react'

export const Footer = () => {
    return (
        <footer>
            <div className="social-medias">
                <ul>
                    <li>
                        <a href="https://github.com/iamdiegoskr/proyect-firebase-heroky" target="_blank" rel="noopener noreferrer">
                            <img src="github.png" alt=""/>
                        </a>
                    </li>
                    <li>
                        <a href="https://www.linkedin.com/in/juan-diego-loaiza-martinez-531b451aa/" target="_blank" rel="noopener noreferrer">
                            <img src="linkedin.png" alt=""/>
                        </a>
                    </li>
                    <li>
                        <a href="https://youtu.be/sAMMpZDKygE" target="_blank" rel="noopener noreferrer">
                            <img src="youtube.png" alt=""/>
                        </a>
                    </li>
                    <li>
                        <a href="https://twitter.com/iamdiegokeloke" target="_blank" rel="noopener noreferrer">
                            <img src="twiter.png" alt=""/>
                        </a>
                    </li>
                </ul>
            </div>
            <div className="profile-creator">
                <p>By Juan Diego Loaiza Martinez <span role="img" aria-label="fire">🔥🔥🔥</span></p>
            </div>
        </footer>
    )
}
