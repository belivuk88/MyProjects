import React from "react";
import ReactDOM from "react-dom";
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import { Route, Link, HashRouter as Router, Switch } from "react-router-dom";
import { Container, Navbar, Nav, Button } from "react-bootstrap";
import Login from "./components/login/Login";
import {logout} from "./services/auth"
import Takmicenje from "./components/takmicenje/Takmicenje";
import AddTakmicenje from "./components/takmicenje/AddTakmicenje";
import Prijava from "./components/takmicenje/Prijava";


class App extends React.Component {
    render(){
        return(
            <div style = {{
                backgroundImage: `url(${process.env.PUBLIC_URL + '/tennis.jpg'})`,
                backgroundPosition: 'center',
                backgroundRepeat: 'no-repeat',
                width: '100vw',
                height: '100vh'}}>
            <div>
                <Router>
                    <Navbar bg="dark" variant="dark" expand>
                        <Navbar.Brand as ={Link} to = "/">
                            <img   src="/tennis-logo.jpg"
                            width="60"
                            height="30"
                            className="d-inline-block align-top"
                            alt="React Bootstrap logo"></img>
                        </Navbar.Brand>
                        <Nav className = "mr-auto">
                            <Nav.Link as ={Link} to ="/takmicenja">
                                Takmicenje
                            </Nav.Link>
                            <Nav.Link as ={Link} to ="/takmicenja/add">
                                AddTakmicenje
                            </Nav.Link>
                            </Nav>

                            {window.localStorage['jwt']?
                            <Button onClick = {()=>logout()}>Log out</Button> :
                            <Nav.Link as ={Link} to = "/login">Log in</Nav.Link>
                        
                            }
                        
                    </Navbar>

                    <Container style = {{marginTop: 25}}>
                        <Switch>
                            <Route exact path = "/" component = {Home}/>
                            <Route exact path = "/takmicenja" component = {Takmicenje}/>
                            <Route exact path = "/takmicenja/add" component = {AddTakmicenje}/>
                            <Route exact path = "/takmicenja/prijava/:id" component = {Prijava}/>
                            <Route exact path = "/login" component = {Login}/>
                            <Route component = {NotFound}/>
                        </Switch>
                    </Container>
                </Router>
            </div>
            </div>
        );
    }
}

ReactDOM.render(<App/>, document.querySelector("#root"));