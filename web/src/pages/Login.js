import React,{useState} from "react";
import firebase from "firebase/app";
import "firebase/firestore";
import "firebase/auth";
import { login } from "../actions/authActions";
import { useAuthState } from "react-firebase-hooks/auth";
import { Link } from "react-router-dom";

firebase.initializeApp({
    apiKey: "AIzaSyDym2qMWJBJ2JwcWp4bHIwF_Aqrf3bxYNs",
    authDomain: "question-and-answer-3003b.firebaseapp.com",
    projectId: "question-and-answer-3003b",
    storageBucket: "question-and-answer-3003b.appspot.com",
    messagingSenderId: "590617390465",
    appId: "1:590617390465:web:aabccafb6838cb67c14c80"
});

const signInWithGoogle = () => {
    const provider = new firebase.auth.GoogleAuthProvider();
    auth.signInWithPopup(provider);
};

const signin = (email, password)=>{
	return auth().signInWithEmailAndPassword(email, password);
}

const auth = firebase.auth();

const Login = ({ dispatch }) => {

    const [userData, setuserData] = useState({
        email:'',
        password:''
    })

    const handleInputChange = (event) => {
        setuserData({
            ...userData,
            [event.target.name] : event.target.value
        })
    }

    const loginUser = (event) => {
        event.preventDefault()
        return auth.signInWithEmailAndPassword(userData.email, userData.password);
    }


    const [user] = useAuthState(auth);
    if (user) {
        dispatch(login(user.email, user.uid));
    }

    return (
        <div className="login-container">
            <form className="form-login" onSubmit={loginUser}>
                <input
                    type="text"
                    id="login"
                    name="email"
                    placeholder="Email"
                    onChange={handleInputChange}
                    value={userData.email}
                />
                <input
                    type="password"
                    id="password"
                    name="password"
                    placeholder="Ingrese contraseña"
                    onChange={handleInputChange}
                    value={userData.password}
                />
                <button type="submit" className="btn-login btn-email">Iniciar sesion</button>
                <button
                    type="button"
                    className="btn-login btn-google"
                    onClick={signInWithGoogle}
                >Iniciar con google</button>
            </form>
            <p>No tienes una cuenta todavia ?<Link to="/Register">REGISTRARSE</Link></p>
        </div>
    )
}

export default Login
